package com.hst.learninghub.user.ui;

import com.hst.learninghub.configuration.SwaggerConfiguration;
import com.hst.learninghub.user.service.UserService;
import com.hst.learninghub.user.ui.request.SignUpRequest;
import com.hst.learninghub.user.ui.request.UserResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dlgusrb0808@gmail.com
 */

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Api(tags = SwaggerConfiguration.USER_API_TAG)
public class UserController {

	private final UserService userService;

	@PostMapping("sign-up")
	public ResponseEntity<UserResponse> signUp(@RequestBody SignUpRequest request) {
		return ResponseEntity.ok(userService.signUp(request));
	}
}
