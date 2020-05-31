package com.hst.learninghub.service;

import com.hst.learninghub.user.service.UserService;
import com.hst.learninghub.user.type.UserRole;
import com.hst.learninghub.user.ui.request.SignUpRequest;
import com.hst.learninghub.user.ui.response.UserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author dlgusrb0808@gmail.com
 */
@SpringBootTest
public class UserServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

	@Autowired
	private UserService userService;

	@Test
	@DisplayName("회원가입")
	public void signUpTest() {
		SignUpRequest request = createSignUpRequest();
		logger.info("회원가입 대상: {}", request);

		UserResponse response = userService.signUp(request);
		assertNotNull(response);
		assertEquals(request.getId(), response.getId());
		assertEquals(request.getName(), response.getName());
		assertEquals(request.getRoleType(), response.getRoleType());
		assertEquals(request.getBirthDate(), response.getBirthDate());
	}

	// 테스트 유저 회원가입 요청
	private SignUpRequest createSignUpRequest() {
		return SignUpRequest.SignUpBuilder()
				.id("gusrb0808")
				.name("이현규")
				.password("hst!!!")
				.birthDate(LocalDateTime.of(1992, 8, 8, 20, 0))
				.roleType(UserRole.NORMAL.getCode())
				.build();
	}

}
