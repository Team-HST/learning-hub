package com.hst.learninghub.content.entity.specs;

import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.content.type.JobClass;
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
	 * JobClass & title로 컨텐츠 검색
	 * @param jobClass 직무분야
	 * @param title 제목
	 * @return Specification 객체
	 */
	public static Specification<Content> byJobClassAndTitle(JobClass jobClass, String title) {
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
