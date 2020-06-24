package com.hst.learninghub.content.entity;

import com.hst.learninghub.common.entity.BaseTimeEntity;
import com.hst.learninghub.file.entity.FileInfo;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "cont_file")
@Getter
@ToString
public class ContentFile extends BaseTimeEntity {
	@EmbeddedId
	private ContentFileId id;

	@Column(name = "del_yn")
	private Boolean deleted;

	public FileInfo getFile() {
		return this.id.getFile();
	}

	public static ContentFile of(Content content, FileInfo file) {
		ContentFile contentFile = new ContentFile();
		contentFile.id = ContentFileId.of(content, file);
		contentFile.deleted = false;
		return contentFile;
	}
}
