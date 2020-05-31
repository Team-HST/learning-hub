package com.hst.learninghub.user.ui.response;

import com.hst.learninghub.user.entity.User;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@ToString
public class UserResponse {
	private Long no;
	private String id;
	private String name;
	private LocalDateTime birthDate;
	private String roleType;

	/***
	 * 사용자 엔티티로 사용자 응답 생성
	 * @param entity 사용자 엔티티
	 * @return 사용자 응답
	 */
	public static UserResponse from(User entity) {
		UserResponse response = new UserResponse();
		response.no = entity.getNo();
		response.id = entity.getId();
		response.name = entity.getName();
		response.birthDate = entity.getBirthDate();
		response.roleType = entity.getRoleType().getCode();

		return response;
	}
}
