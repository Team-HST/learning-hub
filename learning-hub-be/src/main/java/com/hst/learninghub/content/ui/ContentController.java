package com.hst.learninghub.content.ui;

import com.hst.learninghub.configuration.SwaggerConfiguration;
import com.hst.learninghub.content.service.ContentService;
import com.hst.learninghub.content.type.JobClass;
import com.hst.learninghub.content.ui.request.ContentModifyingRequest;
import com.hst.learninghub.content.ui.response.ContentListResponse;
import com.hst.learninghub.content.ui.response.ContentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("contents")
@Api(tags = SwaggerConfiguration.CONTENT_API_TAG)
@RequiredArgsConstructor
@Slf4j
public class ContentController {

	private final ContentService contentService;

	@ApiOperation(value = "컨텐츠 검색 API", notes = "컨텐츠를 검색합니다.")
	@GetMapping("search")
	public ResponseEntity<ContentListResponse> search(
			@ApiParam(name = "jobClass", value = "직무분야코드") @RequestParam(required = false) String jobClass,
			@ApiParam(name = "title", value = "제목") @RequestParam(required = false) String title,
			@PageableDefault Pageable pageable) {
		ContentListResponse searchResult = contentService.searchContents(JobClass.get(jobClass), title, pageable);
		return ResponseEntity.ok(searchResult);
	}

	@ApiOperation(value = "컨텐츠 등록", notes = "컨텐츠를 등록합니다.")
	@PostMapping
	public ResponseEntity<ContentResponse> createContent(
			ContentModifyingRequest request,
		 	@RequestParam(name = "thumbnail", required = false) MultipartFile thumbnail,
			@RequestParam(name = "mainContent") MultipartFile mainContent) throws Exception {
		request.setThumbnail(thumbnail);
		request.setMailContent(mainContent);
		ContentResponse response = contentService.createContent(request);
		return ResponseEntity.ok(response);
	}
}
