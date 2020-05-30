package com.hst.learninghub.user.ui.request;

import com.hst.learninghub.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
@ToString
public class SignUpRequest {
	private String id;
	private String password;
	private String name;
	private LocalDateTime birthDate;
	private String roleType;


}
