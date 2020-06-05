package com.hst.learninghub.content.service;

import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.content.entity.specs.ContentSpecifications;
import com.hst.learninghub.content.repository.ContentRepository;
import com.hst.learninghub.content.type.JobClass;
import com.hst.learninghub.content.ui.response.ContentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
@RequiredArgsConstructor
public class ContentService {

	private final ContentRepository contentRepository;

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
}
