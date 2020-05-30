package com.hst.learninghub.code.service;

import com.hst.learninghub.code.type.GlobalCode;
import com.hst.learninghub.code.ui.response.CodeGroupResponse;
import com.hst.learninghub.common.exception.NotFoundException;
import com.hst.learninghub.common.type.PersistableType;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
public class CodeService {

	/***
	 * 전체 코드그룹 목록 조회
	 * @return 코드그룹 목
	 */
	public List<CodeGroupResponse> getAllCodeGroup() {
		return EnumSet.allOf(GlobalCode.class)
				.stream()
				.map(CodeGroupResponse::from)
				.collect(Collectors.toList());
	}

	/***
	 * 코드그룹 조회
	 * @param codeGroup 코드그룹
	 * @return 코드그룹
	 */
	public CodeGroupResponse getCodeGroup(String codeGroup) {
		Set<? extends PersistableType<?>> codes = GlobalCode.get(codeGroup);
		if (codes == null) {
			throw new NotFoundException("CodeGroup", codeGroup);
		}
		return CodeGroupResponse.of(codeGroup, codes);
	}

}
