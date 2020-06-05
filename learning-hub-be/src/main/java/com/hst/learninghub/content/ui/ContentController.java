package com.hst.learninghub.content.ui;

import com.hst.learninghub.configuration.SwaggerConfiguration;
import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.content.service.ContentService;
import com.hst.learninghub.content.type.JobClass;
import com.hst.learninghub.content.ui.response.ContentResponse;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("contents")
@Api(tags = SwaggerConfiguration.CONTENT_API_TAG)
@RequiredArgsConstructor
public class ContentController {

	private final ContentService contentService;

	@ApiOperation(value = "컨텐츠 검색 API", notes = "컨텐츠를 검색합니다.")
	@GetMapping("search")
	public ResponseEntity<List<ContentResponse>> search(
			@ApiParam(name = "jobClass", value = "직무분야코드") @RequestParam(required = false) String jobClass,
			@ApiParam(name = "title", value = "제목") @RequestParam(required = false) String title,
			@PageableDefault Pageable pageable) {
		List<ContentResponse> searchResult = contentService.searchContents(JobClass.get(jobClass), title, pageable);
		return ResponseEntity.ok(searchResult);
	}

	@ApiOperation(value = "컨텐츠 등록", notes = "컨텐츠를 등록합니다.")
	@PostMapping
	public ResponseEntity<Content> createContent() {
		return null;
	}

}
