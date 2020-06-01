package com.hst.learninghub.common.ui.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@Setter
@ApiModel
public class PaginationRequest {
	@ApiModelProperty(value = "페이지 번호(0..N)")
	private int page;
	@ApiModelProperty(value = "페이지 크기", allowableValues = "range[0, 100]")
	private int size;
}
