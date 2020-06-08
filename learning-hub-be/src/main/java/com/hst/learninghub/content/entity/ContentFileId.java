package com.hst.learninghub.content.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author hyungyu.lee@nhn.com
 */
@Embeddable
@Getter
public class ContentFileId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "content_no")
	private Long contentNo;

	@Column(name = "file_no")
	private Long fileNo;
}
