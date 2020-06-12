package com.hst.learninghub.organization.ui.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dlgusrb0808@gmail.com
 */
@Data
public class OrganizationModifyingRequest {
	@ApiModelProperty(position = 1, value = "기관명")
	private String name;
	@ApiModelProperty(position = 2, value = "주소")
	private String address;
	@ApiModelProperty(position = 3, value = "기관 전화번호")
	private String phoneNumber;
	@ApiModelProperty(position = 4, value = "등록 사용자 No", example = "4")
	private Long registrantNo;
	@ApiModelProperty(position = 5, value = "썸네일", hidden = true)
	private MultipartFile thumbnail;
}
