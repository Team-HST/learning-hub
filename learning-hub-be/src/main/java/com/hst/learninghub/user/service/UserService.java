package com.hst.learninghub.user.service;

import com.hst.learninghub.authentication.AuthenticationToken;
import com.hst.learninghub.authentication.JwtAuthenticationTokenProvider;
import com.hst.learninghub.common.exception.NotFoundException;
import com.hst.learninghub.user.entity.User;
import com.hst.learninghub.user.repository.UserRepository;
import com.hst.learninghub.user.type.LoginStatus;
import com.hst.learninghub.user.type.UserRole;
import com.hst.learninghub.user.ui.request.SignInRequest;
import com.hst.learninghub.user.ui.request.SignUpRequest;
import com.hst.learninghub.user.ui.response.SignInResponse;
import com.hst.learninghub.user.ui.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtAuthenticationTokenProvider jwtTokenProvider;

	public UserService(UserRepository userRepository, JwtAuthenticationTokenProvider jwtTokenProvider) {
		this.userRepository = userRepository;
		this.jwtTokenProvider = jwtTokenProvider;
		this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	public UserResponse signUp(SignUpRequest request) {
		User user = User.SignUpBuilder()
				.id(request.getId())
				.name(request.getName())
				.password(passwordEncoder.encode(request.getPassword()))
				.birthDate(request.getBirthDate())
				.roleType(UserRole.get(request.getRoleType()))
				.build();
		userRepository.save(user);
		return UserResponse.from(user);
	}

	/**
	 * 사용자 로그인
	 * @param request 로그인 요청
	 * @return 로그인 응답 정보
	 */
	public SignInResponse signIn(SignInRequest request) {
		Optional<User> userOpts = userRepository.findById(request.getId());
		if (!userOpts.isPresent()) {
			return SignInResponse.failedLogin(LoginStatus.INVALID_ID);
		}

		User user = userOpts.get();
		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
			return SignInResponse.failedLogin(LoginStatus.INVALID_PASSWORD);
		}

		AuthenticationToken token = jwtTokenProvider.issue(user.getNo());
		return SignInResponse.successLogin(user, token);
	}

	@Override
	public UserDetails loadUserByUsername(String no) throws UsernameNotFoundException {
		return userRepository.findById(Long.valueOf(no))
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Not found id %s", no)));
	}

	public UserResponse getUser(long userNo) {
		Optional<User> userOpts = userRepository.findById(userNo);
		if (!userOpts.isPresent()) {
			throw new NotFoundException("사용자", userNo);
		}
		return UserResponse.from(userOpts.get());
	}
}
