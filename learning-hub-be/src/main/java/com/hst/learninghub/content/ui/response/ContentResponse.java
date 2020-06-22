package com.hst.learninghub.content.ui.response;

import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.file.ui.response.FileResponse;
import com.hst.learninghub.user.ui.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@Builder
public class ContentResponse {
	private Long no;
	private String title;
	private String contents;
	private String jobClassType;
	private Integer donationRatio;
	private LocalDateTime createAt;
	private UserResponse registrant;
	private List<FileResponse> contentFiles;
	private List<ContentReplyResponse> replies;

	public static ContentResponse from(Content content) {
		return builder()
				.no(content.getNo())
				.title(content.getTitle())
				.contents(content.getContents())
				.jobClassType(content.getJobClass().getCode())
				.donationRatio(content.getDonationRatio())
				.createAt(content.getCreatedAt())
				.registrant(UserResponse.from(content.getRegistrant()))
				.contentFiles(content.getContentFiles().stream()
						.map(contentFile -> contentFile.getId().getFile())
						.map(FileResponse::from)
						.collect(Collectors.toList()))
				.build();
	}

	public static ContentResponse fromWithReplies(Content content) {
		return builder()
				.no(content.getNo())
				.title(content.getTitle())
				.contents(content.getContents())
				.jobClassType(content.getJobClass().getCodeName())
				.donationRatio(content.getDonationRatio())
				.createAt(content.getCreatedAt())
				.registrant(UserResponse.from(content.getRegistrant()))
				.contentFiles(content.getContentFiles().stream()
						.map(contentFile -> contentFile.getId().getFile())
						.map(FileResponse::from)
						.collect(Collectors.toList()))
				.replies(content.getReplies().stream().map(ContentReplyResponse::from).collect(Collectors.toList()))
				.build();
	}
}
