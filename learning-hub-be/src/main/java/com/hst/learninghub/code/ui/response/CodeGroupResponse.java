package com.hst.learninghub.code.ui.response;

import com.hst.learninghub.code.type.GlobalCode;
import com.hst.learninghub.common.type.PersistableType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
public class CodeGroupResponse {
	@ApiModelProperty(position = 1, value = "코드그룹", example = "publisher-protocols")
	private String codeGroup;
	@ApiModelProperty(position = 2, value = "코드 목록")
	private Set<CodeResponse> codes;

	public static CodeGroupResponse from(GlobalCode globalCode) {
		return of(globalCode.getCodeGroup(), globalCode.getCodeType());
	}

	public static CodeGroupResponse of(String codeGroup, Set<? extends PersistableType<?>> codes) {
		CodeGroupResponse response = new CodeGroupResponse();
		response.codeGroup = codeGroup;
		response.codes = codes.stream().map(CodeResponse::from).collect(Collectors.toSet());
		return response;
	}
}
