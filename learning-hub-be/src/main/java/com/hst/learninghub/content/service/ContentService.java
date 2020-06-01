package com.hst.learninghub.content.service;

import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.content.repository.ContentRepository;
import com.hst.learninghub.content.type.JobClass;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
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
	public List<Content> searchContents(JobClass jobClass, String title, Pageable pageable) {
		Specification<Content> searchSpec = buildSearchSpec(jobClass, title);
		Page<Content> searchResult = contentRepository.findAll(searchSpec, pageable);
		return searchResult.getContent();
	}

	// 컨텐츠 검색 조건
	private Specification<Content> buildSearchSpec(JobClass jobClass, String title) {
		return (root, query, builder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (jobClass != null) {
				predicates.add(builder.equal(root.get("jobClass"), jobClass));
			}
			if (StringUtils.isNotEmpty(title)) {
				predicates.add(builder.like(root.get("title"), String.format("%%%s%%", title)));
			}
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}

}
