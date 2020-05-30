package com.hst.learninghub.user.type;

import com.hst.learninghub.common.converter.EnumAttributeConverter;
import com.hst.learninghub.common.type.PersistableType;
import com.hst.learninghub.utils.EnumUtils;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
public enum UserRole implements PersistableType<String> {
	OPAL("U001", "오팔(OPAL) 사용자", "컨텐츠를 제작하는 오팔(OPAL)세대 사용자"),
	NORMAL("U002", "일반 사용자", "컨텐츠를 소비하는 일반 사용자")
	;

	private static final Map<String, UserRole> FINDER = EnumUtils.asMap(UserRole.class);

	private String code;
	private String codeName;
	private String description;

	UserRole(String code, String codeName, String description) {
		this.code = code;
		this.codeName = codeName;
		this.description = description;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String getCodeName() {
		return this.codeName;
	}

	public static UserRole get(String code) {
		return FINDER.get(code);
	}

	public static class Converter extends EnumAttributeConverter<UserRole, String> {
		public Converter() {
			super(UserRole.class, false);
		}
	}
}
