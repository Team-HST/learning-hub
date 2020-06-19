package com.hst.learninghub.user.service;

import com.hst.learninghub.authentication.model.AuthenticationToken;
import com.hst.learninghub.authentication.provider.AuthenticationTokenProvider;
import com.hst.learninghub.common.exception.NotFoundException;
import com.hst.learninghub.file.entity.FileInfo;
import com.hst.learninghub.file.service.FileService;
import com.hst.learninghub.file.type.FileType;
import com.hst.learninghub.user.entity.User;
import com.hst.learninghub.user.repository.UserRepository;
import com.hst.learninghub.user.type.LoginStatus;
import com.hst.learninghub.user.type.UserRole;
import com.hst.learninghub.user.ui.request.SignInRequest;
import com.hst.learninghub.user.ui.request.SignUpRequest;
import com.hst.learninghub.user.ui.response.SignInResponse;
import com.hst.learninghub.user.ui.response.UserResponse;
import com.hst.learninghub.utils.TimeUtils;
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
	private final AuthenticationTokenProvider authenticationTokenProvider;
	private final FileService fileService;

	public UserService(UserRepository userRepository, AuthenticationTokenProvider authenticationTokenProvider, FileService fileService) {
		this.userRepository = userRepository;
		this.authenticationTokenProvider = authenticationTokenProvider;
		this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		this.fileService = fileService;
	}

	/**
	 * 회원가입
	 * @param request 회원가입 요청
	 * @return 가입된 회원정보
	 */
	public UserResponse signUp(SignUpRequest request) throws Exception {
		User user = User.builder()
				.id(request.getId())
				.name(request.getName())
				.password(passwordEncoder.encode(request.getPassword()))
				.birthDate(TimeUtils.parse(request.getBirthDate()))
				.roleType(UserRole.get(request.getRoleType()))
				.deleted(false)
				.build();


		FileInfo uploadedFileInfo = fileService.uploadFile(request.getProfileImage(), FileType.PROFILE_IMAGE);
		user.changeUserProfile(uploadedFileInfo);
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

		AuthenticationToken token = authenticationTokenProvider.issue(user.getNo());
		return SignInResponse.successLogin(user, token);
	}

	/***
	 * 회원정보 조회
	 * @param userNo 회원 No
	 * @return 회원정보
	 */
	public UserResponse getUser(long userNo) {
		return UserResponse.from(getUserEntity(userNo));
	}

	/***
	 * 회원정보 엔티티 조회
	 * @param userNo
	 * @return
	 */
	public User getUserEntity(long userNo) {
		Optional<User> userOpts = userRepository.findById(userNo);
		return userOpts.orElseThrow(() -> new NotFoundException("사용자", userNo));
	}

	@Override
	public UserDetails loadUserByUsername(String no) throws UsernameNotFoundException {
		return userRepository.findById(Long.valueOf(no))
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Not found id %s", no)));
	}
}
