package com.hst.learninghub.content.service;

import com.hst.learninghub.common.exception.NotFoundException;
import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.content.entity.ContentFile;
import com.hst.learninghub.content.entity.specs.ContentSpecifications;
import com.hst.learninghub.content.repository.ContentRepository;
import com.hst.learninghub.content.type.JobClass;
import com.hst.learninghub.content.ui.request.ContentModifyingRequest;
import com.hst.learninghub.content.ui.response.ContentListResponse;
import com.hst.learninghub.content.ui.response.ContentResponse;
import com.hst.learninghub.donation.service.DonationService;
import com.hst.learninghub.file.entity.FileInfo;
import com.hst.learninghub.file.service.FileService;
import com.hst.learninghub.file.type.FileType;
import com.hst.learninghub.organization.service.OrganizationService;
import com.hst.learninghub.organization.ui.response.OrganizationResponse;
import com.hst.learninghub.user.service.UserService;
import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
@RequiredArgsConstructor
public class ContentService {

//	private final ContentDonOrgRepository contentDonationOrgRepository;
	private final ContentRepository contentRepository;
	private final UserService userService;
	private final FileService fileService;
	private final OrganizationService organizationService;
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
		return contentRepository.findById(contentNo)
				.map(content -> ContentResponse.of(content, donationService.getContentDonationOrgs(contentNo)))
				.orElseThrow(() -> new NotFoundException("컨텐츠", contentNo));
	}

	/***
	 * 컨텐츠 등록
	 * @param request
	 * @return
	 */
	@Transactional
	public ContentResponse createContent(ContentModifyingRequest request) throws Exception {
		Content createdContent = Content.builder()
				.title(request.getTitle())
				.contents(request.getContents())
				.jobClass(JobClass.get(request.getJobClassType()))
				.donationRatio(request.getDonationRatio())
				.registrant(userService.getUserEntity(request.getRegistrantNo()))
				.build();

		if (Optional.ofNullable(request.getThumbnail()).isPresent()) {
			FileInfo uploadedFileInfo = fileService.uploadFile(request.getThumbnail(), FileType.THUMBNAIL);
			createdContent.getContentFiles().add(ContentFile.of(createdContent, uploadedFileInfo));
		}

		FileInfo uploadedFileInfo = fileService.uploadFile(request.getMailContent(), FileType.MAIN_MOVIE);
		createdContent.getContentFiles().add(ContentFile.of(createdContent, uploadedFileInfo));

		contentRepository.save(createdContent);

		List<Long> donationOrgNoList = request.getDonationOrgNos();
		if (!Collections.isEmpty(donationOrgNoList)) {
			for (Long donationOrgNo : donationOrgNoList) {
				donationService.addContentDonationOrg(createdContent.getNo(), donationOrgNo, request.getRegistrantNo());
			}
		}

		return getContent(createdContent.getNo());
	}

	/***
	 * 컨텐츠에 후원
	 * @param contentNo 컨텐츠 No
	 */
	public void donate(Long contentNo) {
		Content content = contentRepository.findById(contentNo)
				.orElseThrow(() -> new NotFoundException("컨텐츠", contentNo));


	}
}
