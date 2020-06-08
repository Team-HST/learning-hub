package com.hst.learninghub.content.entity;

import com.hst.learninghub.common.entity.BaseTimeEntity;
import com.hst.learninghub.content.type.JobClass;
import com.hst.learninghub.user.entity.User;
import lombok.*;

import javax.persistence.*;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "content")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Content extends BaseTimeEntity {

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
	@Convert(converter = JobClass.Converter.class)
	private JobClass jobClass;

	@Column(name = "don_rate")
	private Integer donationRatio;

	@Column(name = "del_yn")
	private boolean deleted;

	@ManyToOne
	@JoinColumn(name = "reg_user_no")
	private User registrant;
}
