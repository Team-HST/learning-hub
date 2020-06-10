package com.hst.learninghub.file.entity;

import com.hst.learninghub.file.type.FileType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "file_mgt")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class FileInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_no")
	private Long no;

	@Column(name = "file_nm")
	private String savedName;

	@Column(name = "file_org_nm")
	private String originalName;

	@Column(name = "file_path")
	private String path;

	@Column(name = "file_ext")
	private String extention;

	@Column(name = "file_size")
	private long size;

	@Column(name = "del_yn")
	private Boolean deleted;

	@Column(name = "file_type_cd")
	@Convert(converter = FileType.Converter.class)
	private FileType fileType;

	@Column(name = "reg_user_no")
	private Long registrantUserNo;

	@CreatedDate
	@Column(name = "REG_DTM")
	private LocalDateTime createdAt;

	public String getSavedPath() {
		return String.format("%s%s%s", this.path, File.separator, this.savedName);
	}
}
