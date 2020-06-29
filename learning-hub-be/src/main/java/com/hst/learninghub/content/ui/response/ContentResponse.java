package com.hst.learninghub.content.ui.response;

import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.file.ui.response.FileResponse;
import com.hst.learninghub.user.ui.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@Builder
public class ContentResponse {
	private final Long no;
	private final String title;
	private final String contents;
	private final String jobClassType;
	private final Integer donationRatio;
	private final LocalDateTime createAt;
	private final UserResponse registrant;
	private final FileResponse thumbnailFile;
	private final FileResponse mainContentFile;

	public static ContentResponse from(Content content) {
		return builder()
				.no(content.getNo())
				.title(content.getTitle())
				.contents(content.getContents())
				.jobClassType(content.getJobCategory().getCode())
				.donationRatio(content.getDonationRatio())
				.createAt(content.getCreatedAt())
				.registrant(UserResponse.from(content.getRegistrant()))
				.thumbnailFile(FileResponse.from(content.getThumbnailFile()))
				.mainContentFile(FileResponse.from(content.getMainContentFile()))
				.build();
	}
}
