package com.hst.learninghub.content.entity;

import com.hst.learninghub.file.entity.FileInfo;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author dlgusrb0808@gmail.com
 */
@Embeddable
@Getter
public class ContentFileId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "content_no")
	private Content content;

	@ManyToOne
	@JoinColumn(name = "file_no")
	private FileInfo file;

	public static ContentFileId of(Content content, FileInfo file) {
		ContentFileId id = new ContentFileId();
		id.content = content;
		id.file = file;
		return id;
	}
}
