package com.hst.learninghub.code.ui.response;

import com.hst.learninghub.common.type.PersistableType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class CodeResponse {
	@ApiModelProperty(position = 1, value = "코드명", example = "email")
	private String code;
	@ApiModelProperty(position = 2, value = "코드이름", example = "Email")
	private String codeName;
	@ApiModelProperty(position = 3, value = "코드설명", example = "이메일 타입")
	private String description;

	public static CodeResponse from(PersistableType<?> type) {
		return CodeResponse.builder()
				.code(type.getCode().toString())
				.codeName(type.getCodeName())
				.description(type.getDescription())
				.build();
	}
}
