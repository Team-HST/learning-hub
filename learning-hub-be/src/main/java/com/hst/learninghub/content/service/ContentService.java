package com.hst.learninghub.content.service;

import com.hst.learninghub.common.exception.NotFoundException;
import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.content.entity.ContentFile;
import com.hst.learninghub.content.entity.ContentReply;
import com.hst.learninghub.content.entity.specs.ContentSpecifications;
import com.hst.learninghub.content.repository.ContentReplyRepository;
import com.hst.learninghub.content.repository.ContentRepository;
import com.hst.learninghub.content.type.JobClass;
import com.hst.learninghub.content.ui.request.ContentModifyingRequest;
import com.hst.learninghub.content.ui.request.ContentReplyModifyingRequest;
import com.hst.learninghub.content.ui.response.ContentListResponse;
import com.hst.learninghub.content.ui.response.ContentReplyResponse;
import com.hst.learninghub.content.ui.response.ContentResponse;
import com.hst.learninghub.donation.service.DonationService;
import com.hst.learninghub.donation.ui.request.DonateContentRequest;
import com.hst.learninghub.file.entity.FileInfo;
import com.hst.learninghub.file.service.FileService;
import com.hst.learninghub.file.type.FileType;
import com.hst.learninghub.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
@RequiredArgsConstructor
public class ContentService {
	private final ContentRepository contentRepository;
	private final ContentReplyRepository contentReplyRepository;
	private final UserService userService;
	private final FileService fileService;
	private final DonationService donationService;

	/***
	 * 컨텐츠 검색
	 * @param jobClass 카테고리
	 * @param title 검색
	 * @param pageable 페이징
	 * @return 검색결과
	 */
	public ContentListResponse searchContents(JobClass jobClass, String title, Pageable pageable) {
		Specification<Content> searchSpec = ContentSpecifications.byJobClassAndTitle(jobClass, title);
		Page<Content> searchResult = contentRepository.findAll(searchSpec, pageable);
		return ContentListResponse.from(searchResult);
	}


	/***
	 * 컨텐츠 조회
	 * @param contentNo 컨텐츠 번호
	 * @return 컨텐츠
	 */
	public ContentResponse getContent(Long contentNo) {
		return ContentResponse.from(getContentEntity(contentNo));
	}

	/***
	 * 컨텐츠 등록
	 * @param request
	 * @return
	 */
	@Transactional
	public ContentResponse createContent(ContentModifyingRequest request) throws Exception {
		Content content = Content.builder()
				.title(request.getTitle())
				.contents(request.getContents())
				.jobClass(JobClass.get(request.getJobClassType()))
				.donationRatio(request.getDonationRatio())
				.registrant(userService.getUserEntity(request.getRegistrantNo()))
				.build();

		if (Optional.ofNullable(request.getThumbnail()).isPresent()) {
			FileInfo uploadedFileInfo = fileService.uploadFile(request.getThumbnail(), FileType.THUMBNAIL);
			content.getContentFiles().add(ContentFile.of(content, uploadedFileInfo));
		}

		FileInfo uploadedFileInfo = fileService.uploadFile(request.getMailContent(), FileType.MAIN_MOVIE);
		content.getContentFiles().add(ContentFile.of(content, uploadedFileInfo));

		contentRepository.save(content);

		return getContent(content.getNo());
	}

	/***
	 * 컨텐츠에 후원
	 * @param contentNo 컨텐츠 No
	 * @param donationAmount
	 */
	@Transactional
	public void donate(Long contentNo, Long orgNo, Integer donationAmount, Long donateUserNo) {
		Content content = getContentEntity(contentNo);

		donationService.donate(DonateContentRequest.builder()
				.content(content)
				.orgNo(orgNo)
				.donationAmount(donationAmount)
				.donateUserNo(donateUserNo)
				.build());
	}

	/***
	 * 댓글 등록
	 * @param request 요청
	 * @return 등록 결과
	 */
	@Transactional
	public ContentReplyResponse reply(ContentReplyModifyingRequest request) {
		Content content = getContentEntity(request.getContentNo());
		ContentReply reply = ContentReply.builder()
				.content(content)
				.contents(request.getContents())
				.registrant(userService.getUserEntity(request.getRegistrantNo()))
				.build();
		contentReplyRepository.save(reply);
		return ContentReplyResponse.from(reply);
	}

	private Content getContentEntity(Long contentNo) {
		return contentRepository.findById(contentNo)
				.orElseThrow(() -> new NotFoundException("컨텐츠", contentNo));
	}
}
