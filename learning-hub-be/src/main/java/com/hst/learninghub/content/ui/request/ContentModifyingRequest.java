package com.hst.learninghub.content.ui.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author dlgusrb0808@gmail.com
 */
@Data
public class ContentModifyingRequest {
	@ApiModelProperty(position = 1, example = "제목")
	private String title;
	@ApiModelProperty(position = 2, example = "내용")
	private String contents;
	@ApiModelProperty(position = 3, example = "직무분야코드")
	private String jobClassType;
	@ApiModelProperty(position = 4, example = "기부율")
	private int donationRatio;
	@ApiModelProperty(position = 5, example = "등록 사용자 No")
	private Long registrantNo;
}
