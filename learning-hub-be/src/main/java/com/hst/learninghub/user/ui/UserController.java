package com.hst.learninghub.user.ui;

import com.hst.learninghub.configuration.SwaggerConfiguration;
import com.hst.learninghub.user.service.UserService;
import com.hst.learninghub.user.ui.request.SignInRequest;
import com.hst.learninghub.user.ui.request.SignUpRequest;
import com.hst.learninghub.user.ui.response.SignInResponse;
import com.hst.learninghub.user.ui.response.UserDonationResponse;
import com.hst.learninghub.user.ui.response.UserResponse;
import com.hst.learninghub.user.ui.response.UserRevenueResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Api(tags = SwaggerConfiguration.USER_API_TAG)
public class UserController {
	private final UserService userService;

	@ApiOperation(value = "사용자 회원가입", notes = "사용자 회원가입")
	@PostMapping("sign-up")
	public ResponseEntity<UserResponse> signUp(@RequestBody SignUpRequest request){
		UserResponse response = userService.signUp(request);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "사용자 로그인", notes = "로그인 인증 및 토큰 발급")
	@PostMapping("sign-in")
	public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest request) {
		return ResponseEntity.ok(userService.signIn(request));
	}

	@ApiOperation(value = "사용자 조회", notes = "사용자 조회")
	@GetMapping("/{userNo}")
	public ResponseEntity<UserResponse> getUser(@PathVariable long userNo){
		return ResponseEntity.ok(userService.getUser(userNo));
	}

	@ApiOperation(value = "사용자 수익금 현황 조회", notes = "사용자 총 수익금 현황 조회")
	@GetMapping("/{userNo}/revenueStatus")
	public ResponseEntity<UserRevenueResponse> getUserRevenueStatus(@PathVariable long userNo) {
		return ResponseEntity.ok(userService.getUserRevenueStatus(userNo));
	}

	@ApiOperation(value = "사용자 기부금 현황 조회", notes = "사용자 총 기부금 현황 조회")
	@GetMapping("/{userNo}/donationStatus")
	public ResponseEntity<UserDonationResponse> getUserDonationStatus(@PathVariable long userNo) {
		return ResponseEntity.ok(userService.getUserDonationStatus(userNo));
	}
}
