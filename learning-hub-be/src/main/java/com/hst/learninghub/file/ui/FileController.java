package com.hst.learninghub.file.ui;

import com.hst.learninghub.configuration.SwaggerConfiguration;
import com.hst.learninghub.file.model.FileRawData;
import com.hst.learninghub.file.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("files")
@Api(tags = SwaggerConfiguration.FILE_API_TAG)
@RequiredArgsConstructor
public class FileController {

	private final FileService fileService;

	@ApiOperation(value = "파일 바이너리 서빙 API", notes = "컨텐츠를 검색합니다.")
	@GetMapping("{fileNo}")
	public ResponseEntity<byte[]> serveFile(
			@ApiParam(name = "fileNo", value = "파일 No", example = "4") @PathVariable Long fileNo) throws IOException {
		FileRawData fileRawData = fileService.getFileRawData(fileNo);

		return ResponseEntity.status(HttpStatus.OK)
				.contentType(fileRawData.getMediaType())
				.body(fileRawData.getRawData());
	}
}
