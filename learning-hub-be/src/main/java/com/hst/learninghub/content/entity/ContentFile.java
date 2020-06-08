package com.hst.learninghub.content.entity;

import com.hst.learninghub.common.entity.BaseTimeEntity;
import com.hst.learninghub.content.type.ContentFileType;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "cont_file")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ContentFile extends BaseTimeEntity {
	@EmbeddedId
	private ContentFileId id;

	@Column(name = "del_yn")
	private Boolean deleted;

	@Column(name = "content_file_type")
	@Convert(converter = ContentFileType.Converter.class)
	private ContentFileType fileType;
}
