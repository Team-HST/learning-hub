package com.hst.learninghub.code.type;

import com.hst.learninghub.common.type.PersistableType;
import com.hst.learninghub.content.type.JobCategory;
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
	USER_ROLE_CODE("UserRoles", EnumSet.allOf(UserRole.class)),
	LOGIN_STATUS_CODE("LoginStatus", EnumSet.allOf(LoginStatus.class)),
	JOB_CATEGORY_CODE("JobCategories", EnumSet.allOf(JobCategory.class)),
	;

	private static final Map<String, GlobalCode> FINDER = EnumUtils.asMap(GlobalCode.class, e -> e.codeGroup);

	private String codeGroup;
	private Set<? extends PersistableType<?>> codeType;

	public static Set<? extends PersistableType<?>> get(String codeGroup) {
		return FINDER.get(codeGroup).codeType;
	}
}
