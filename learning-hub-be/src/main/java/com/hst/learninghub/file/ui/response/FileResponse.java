package com.hst.learninghub.file.ui.response;

import com.hst.learninghub.file.entity.FileInfo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@Builder
public class FileResponse {
	private long fileNo;
	private String fileTypeCode;
	private LocalDateTime createAt;

	public static FileResponse from(FileInfo file) {
		return FileResponse.builder()
				.fileNo(file.getNo())
				.fileTypeCode(file.getFileType().getCode())
				.createAt(file.getCreatedAt())
				.build();
	}
}
