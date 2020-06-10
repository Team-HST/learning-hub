package com.hst.learninghub.content.service;

import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.content.entity.ContentFile;
import com.hst.learninghub.content.entity.specs.ContentSpecifications;
import com.hst.learninghub.content.repository.ContentRepository;
import com.hst.learninghub.content.type.JobClass;
import com.hst.learninghub.content.ui.request.ContentModifyingRequest;
import com.hst.learninghub.content.ui.response.ContentResponse;
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

import java.util.List;
import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
@RequiredArgsConstructor
public class ContentService {

	private final ContentRepository contentRepository;
	private final UserService userService;
	private final FileService fileService;

	/***
	 * 컨텐츠 검색
	 * @param jobClass 카테고리
	 * @param title 검색
	 * @param pageable 페이징
	 * @return 검색결과
	 */
	public List<ContentResponse> searchContents(JobClass jobClass, String title, Pageable pageable) {
		Specification<Content> searchSpec = ContentSpecifications.byJobClassAndTitle(jobClass, title);
		Page<Content> searchResult = contentRepository.findAll(searchSpec, pageable);
		return searchResult.map(ContentResponse::from).getContent();
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

		return ContentResponse.from(createdContent);
	}
}
