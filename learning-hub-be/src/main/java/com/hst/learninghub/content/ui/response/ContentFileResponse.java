package com.hst.learninghub.content.ui.response;

import com.hst.learninghub.content.entity.ContentFile;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@Builder
public class ContentFileResponse {
	private long fileNo;
	private String fileTypeCode;
	private LocalDateTime createAt;

	public static ContentFileResponse from(ContentFile contentFile) {
		return ContentFileResponse.builder()
				.fileNo(contentFile.getId().getFileNo())
				.fileTypeCode(contentFile.getFileType().getCode())
				.createAt(contentFile.getCreatedAt())
				.build();
	}
}
