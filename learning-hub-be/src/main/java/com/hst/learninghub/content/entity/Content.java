package com.hst.learninghub.content.entity;

import com.hst.learninghub.common.entity.BaseTimeEntity;
import com.hst.learninghub.content.type.JobCategory;
import com.hst.learninghub.file.entity.FileInfo;
import com.hst.learninghub.file.type.FileType;
import com.hst.learninghub.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "content")
@Getter
@NoArgsConstructor
public class Content extends BaseTimeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "content_no")
	private Long no;

	@Column(name = "content_title")
	private String title;

	@Column(name = "contents")
	private String contents;

	@Column(name = "job_class_cd")
	@Convert(converter = JobCategory.Converter.class)
	private JobCategory jobCategory;

	@Column(name = "don_rate")
	private Integer donationRatio;

	@Column(name = "del_yn")
	private Boolean deleted;

	@ManyToOne
	@JoinColumn(name = "reg_user_no")
	private User registrant;

	@OneToMany(mappedBy = "content", cascade = CascadeType.ALL)
	private List<ContentReply> replies = new ArrayList<>();

	@OneToMany(mappedBy = "id.content", cascade = CascadeType.ALL)
	private List<ContentFile> contentFiles = new ArrayList<>();

	@Builder
	public Content(String title, String contents, JobCategory jobCategory, Integer donationRatio, User registrant) {
		this.title = title;
		this.contents = contents;
		this.jobCategory = jobCategory;
		this.donationRatio = donationRatio;
		this.registrant = registrant;
		this.deleted = false;
	}

	public FileInfo getThumbnailFile() {
		return this.contentFiles.stream()
				.map(ContentFile::getFile)
				.filter(file -> file.getFileType() == FileType.THUMBNAIL)
				.findFirst()
				.orElse(null);
	}

	public FileInfo getMainContentFile() {
		return this.contentFiles.stream()
				.map(ContentFile::getFile)
				.filter(file -> file.getFileType() == FileType.MAIN_MOVIE)
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("메인 컨텐츠가 존재하지 않음"));
	}
}
