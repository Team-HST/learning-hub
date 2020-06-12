package com.hst.learninghub.content.ui.response;

import com.hst.learninghub.content.entity.ContentReply;
import com.hst.learninghub.user.ui.response.UserResponse;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
public class ContentReplyResponse {
	private Long no;
	private String contents;
	private UserResponse registrant;
	private LocalDateTime createdAt;

	public static ContentReplyResponse from(ContentReply contentReply) {
		ContentReplyResponse response = new ContentReplyResponse();
		response.no = contentReply.getNo();
		response.contents = contentReply.getContents();
		response.registrant = UserResponse.from(contentReply.getRegistrant());
		response.createdAt = contentReply.getCreatedAt();
		return response;
	}
}
