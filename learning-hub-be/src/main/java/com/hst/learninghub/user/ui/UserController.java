package com.hst.learninghub.user.ui;

import com.hst.learninghub.configuration.SwaggerConfiguration;
import com.hst.learninghub.user.entity.User;
import com.hst.learninghub.user.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Api(tags = SwaggerConfiguration.USER_API_TAG)
public class UserController {
	private final UserService userService;

	@GetMapping
	public List<User> greeting() {
		return userService.getUsers();
	}
}
