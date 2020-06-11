package com.hst.learninghub.content.ui.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author dlgusrb0808@gmail.com
 */
@Data
public class ContentReplyModifyingRequest {
	private String contents;
	private Long registrantNo;
	@JsonIgnore
	private Long contentNo;
}
