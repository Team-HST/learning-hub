package com.hst.learninghub.content.ui;

import com.hst.learninghub.configuration.SwaggerConfiguration;
import com.hst.learninghub.content.entity.ContentReply;
import com.hst.learninghub.content.service.ContentService;
import com.hst.learninghub.content.type.JobClass;
import com.hst.learninghub.content.ui.request.ContentModifyingRequest;
import com.hst.learninghub.content.ui.request.ContentReplyModifyingRequest;
import com.hst.learninghub.content.ui.response.ContentListResponse;
import com.hst.learninghub.content.ui.response.ContentReplyResponse;
import com.hst.learninghub.content.ui.response.ContentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
			@PageableDefault(sort = "no", direction = Sort.Direction.DESC) Pageable pageable) {
		ContentListResponse searchResult = contentService.searchContents(JobClass.get(jobClass), title, pageable);
		return ResponseEntity.ok(searchResult);
	}

	@ApiOperation(value = "컨텐츠 조회", notes = "컨텐츠 한 건을 검색합니다.")
	@GetMapping("{contentNo}")
	public ResponseEntity<ContentResponse> getContent(
			@ApiParam(name = "contentNo", value = "컨텐츠 No", example = "15") @PathVariable Long contentNo) {
		return ResponseEntity.ok(contentService.getContent(contentNo));
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

	@ApiOperation(value = "컨텐츠 후원", notes = "컨텐츠에 등록된 기관에 후원합니다.")
	@PostMapping("donate/{contentNo}/{orgNo}")
	public ResponseEntity<String> donate(
			@ApiParam(name = "contentNo", value = "컨텐츠 No", example = "15") @PathVariable Long contentNo,
			@ApiParam(name = "orgNo", value = "기관 No", example = "15") @PathVariable Long orgNo,
			@ApiParam(name = "donationAmount", value = "후원금액", example = "15") @RequestParam Integer donationAmount,
			@ApiParam(name = "donateUserNo", value = "후원 사용자 번호", example = "15") @RequestParam Long donateUserNo) {
		contentService.donate(contentNo, orgNo, donationAmount, donateUserNo);
		return ResponseEntity.ok("");
	}

	@ApiOperation(value = "컨텐츠 댓글 등록", notes = "컨텐츠에 댓글을 등록합니다.")
	@PostMapping("{contentNo}/reply")
	public ResponseEntity<ContentReplyResponse> reply(
			@ApiParam(name = "contentNo", value = "컨텐츠 No", example = "15") @PathVariable Long contentNo,
			@RequestBody ContentReplyModifyingRequest request) {
		request.setContentNo(contentNo);
		return ResponseEntity.ok(contentService.reply(request));
	}
}
