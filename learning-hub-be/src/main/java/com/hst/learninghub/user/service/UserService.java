package com.hst.learninghub.user.service;

import com.hst.learninghub.authentication.model.AuthenticationToken;
import com.hst.learninghub.authentication.provider.AuthenticationTokenProvider;
import com.hst.learninghub.authentication.provider.JwtAuthenticationTokenProvider;
import com.hst.learninghub.common.exception.NotFoundException;
import com.hst.learninghub.content.repository.ContentRepository;
import com.hst.learninghub.donation.entity.ContDonation;
import com.hst.learninghub.donation.repository.ContentDonRepository;
import com.hst.learninghub.user.entity.User;
import com.hst.learninghub.user.entity.UserReceipt;
import com.hst.learninghub.user.repository.UserReceiptRepository;
import com.hst.learninghub.user.repository.UserRepository;
import com.hst.learninghub.user.type.LoginStatus;
import com.hst.learninghub.user.type.UserRole;
import com.hst.learninghub.user.ui.request.SignInRequest;
import com.hst.learninghub.user.ui.request.SignUpRequest;
import com.hst.learninghub.user.ui.response.SignInResponse;
import com.hst.learninghub.user.ui.response.UserDonationResponse;
import com.hst.learninghub.user.ui.response.UserResponse;
import com.hst.learninghub.user.ui.response.UserRevenueResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final UserReceiptRepository userReceiptRepository;
	private final ContentRepository contentRepository;
	private final ContentDonRepository contentDonRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationTokenProvider authenticationTokenProvider;

	public UserService(UserRepository userRepository, UserReceiptRepository userReceiptRepository, ContentRepository contentRepository,
					   ContentDonRepository contentDonRepository, AuthenticationTokenProvider authenticationTokenProvider) {
		this.userRepository = userRepository;
		this.userReceiptRepository = userReceiptRepository;
		this.contentRepository = contentRepository;
		this.contentDonRepository = contentDonRepository;
		this.authenticationTokenProvider = authenticationTokenProvider;
		this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	/**
	 * 회원가입
	 * @param request 회원가입 요청
	 * @return 가입된 회원정보
	 */
	public UserResponse signUp(SignUpRequest request) {
		User user = User.builder()
				.id(request.getId())
				.name(request.getName())
				.password(passwordEncoder.encode(request.getPassword()))
				.birthDate(request.getBirthDate())
				.roleType(UserRole.get(request.getRoleType()))
				.deleted(false)
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

	/**
	 * 사용자 총 수익금 현황 조회
	 * @param userNo
	 * @return 사용자 수익금 현황
	 */
	public UserRevenueResponse getUserRevenueStatus(long userNo) {
		List<Long> contentNoList = contentRepository.findIdByUserNo(userNo);
		List<ContDonation> userRevenueList = contentDonRepository.findAllByContentUserNo(contentNoList);
		// UserReceipt userReceipt = userReceiptRepository.findTotReceiptAmountByUserNo(userNo);
		Long totalReceiptAmount = userReceiptRepository.findTotReceiptAmountByUserNo(userNo);
		return UserRevenueResponse.userRevenueStatus(userRevenueList, totalReceiptAmount);
	}

	public UserDonationResponse getUserDonationStatus(long userNo) {
		return UserDonationResponse.userDonationStatus(contentDonRepository.findSumAmountByDonUserNo(userNo));
	}
}
