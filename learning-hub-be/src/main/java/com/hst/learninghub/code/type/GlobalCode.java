package com.hst.learninghub.code.type;

import com.hst.learninghub.common.type.PersistableType;
import com.hst.learninghub.user.type.LoginStatus;
import com.hst.learninghub.user.type.UserRole;
import com.hst.learninghub.utils.EnumUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dlgusrb0808@gmail.com
 */
@AllArgsConstructor
@Getter
public enum GlobalCode {
	USER_ROLE_CODE("user-roles", EnumSet.allOf(UserRole.class)),
	LOGIN_STATUS_CODE("login-status", EnumSet.allOf(LoginStatus.class)),
	;

	private static final Map<String, GlobalCode> FINDER = EnumUtils.asMap(GlobalCode.class, e -> e.codeGroup);

	private String codeGroup;
	private Set<? extends PersistableType<?>> codeType;

	public static Set<? extends PersistableType<?>> get(String codeGroup) {
		return FINDER.get(codeGroup).codeType;
	}
}
