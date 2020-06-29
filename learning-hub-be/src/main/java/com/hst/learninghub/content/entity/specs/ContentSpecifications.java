package com.hst.learninghub.content.entity.specs;

import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.content.type.JobCategory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContentSpecifications {

	/***
	 * 직무분야 & 제목으로 컨텐츠 검색
	 * @param jobCategory 직무분야
	 * @param title 제목
	 * @return Specification 객체
	 */
	public static Specification<Content> byJobClassAndTitle(JobCategory jobCategory, String title) {
		return (root, query, builder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (jobCategory != null) {
				predicates.add(builder.equal(root.get("jobCategory"), jobCategory));
			}
			if (StringUtils.isNotEmpty(title)) {
				predicates.add(builder.like(root.get("title"), String.format("%%%s%%", title)));
			}
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}

}
