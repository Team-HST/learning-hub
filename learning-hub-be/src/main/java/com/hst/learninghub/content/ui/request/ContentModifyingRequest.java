package com.hst.learninghub.content.ui.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dlgusrb0808@gmail.com
 */
@Data
public class ContentModifyingRequest {
	@ApiModelProperty(position = 1, value = "제목")
	private String title;
	@ApiModelProperty(position = 2, value = "내용")
	private String contents;
	@ApiModelProperty(position = 3, value = "직무분야코드")
	private String jobCategory;
	@ApiModelProperty(position = 4, value = "기부율(%)", example = "10")
	private Integer donationRatio;
	@ApiModelProperty(position = 5, value = "등록 사용자 No", example = "4")
	private Long registrantNo;
	@ApiModelProperty(position = 6, value = "썸네일", hidden = true)
	private MultipartFile thumbnail;
	@ApiModelProperty(position = 7, value = "메인 영상 파일", hidden = true)
	private MultipartFile mailContent;
}
