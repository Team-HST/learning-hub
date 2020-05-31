package com.hst.learninghub.user.service;

import com.hst.learninghub.authentication.AuthenticationToken;
import com.hst.learninghub.authentication.JwtAuthenticationTokenProvider;
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
import org.springframework.stereotype.Service;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final JwtAuthenticationTokenProvider jwtTokenProvider;

	public UserService(UserRepository userRepository, JwtAuthenticationTokenProvider jwtTokenProvider) {
		this.userRepository = userRepository;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	/***
	 * 사용자 회원가입
	 * @param request 회원가입 요청
	 * @return 가입된 사용자 정보
	 */
	public UserResponse signUp(SignUpRequest request) {
		User user = User.builder()
				.id(request.getId())
				.name(request.getName())
				.password(request.getPassword())
				.birthDate(request.getBirthDate())
				.roleType(UserRole.get(request.getRoleType()))
				.build();
		user = userRepository.save(user);
		return UserResponse.from(user);
	}

	/**
	 * 사용자 로그인
	 * @param request 로그인 요청
	 * @return 로그인 응답 정보
	 */
	public SignInResponse signIn(SignInRequest request) {
		AuthenticationToken authenticationToken = null;	// 토큰 정보
		SignInResponse response = new SignInResponse();	// 로그인 응답 정보
		LoginStatus loginStatus = null;					// 로그인 상태
		String inputPassword = request.getPassword();	// 사용자 패스워드

		/** 사용자 조회 */
		User user = userRepository.findById(request.getId());

		if (user != null) {
			Long userNo = user.getNo();

			// 비밀번호가 틀린 경우
			if (!inputPassword.equals(user.getPassword())) {
				return SignInResponse.failedLogin(LoginStatus.INVALID_PASSWORD);
			}
			// 사용자 토큰 생성
			authenticationToken = jwtTokenProvider.issue(userNo);

		// 사용자를 찾을 수 없는 경우
		} else {
			return SignInResponse.failedLogin(LoginStatus.INVALID_ID);
		}

		return SignInResponse.successLogin(user, authenticationToken.getToken());
	}

	@Override
	public UserDetails loadUserByUsername(String no) throws UsernameNotFoundException {
		return userRepository.findById(Long.valueOf(no))
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Not found id %s", no)));
	}
}
