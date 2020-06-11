package com.hst.learninghub.content.entity;

import com.hst.learninghub.common.entity.BaseTimeEntity;
import com.hst.learninghub.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "reply")
@Getter
@NoArgsConstructor
public class ContentReply extends BaseTimeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reply_no")
	private Long no;

	@Column(name = "contents")
	private String contents;

	@Column(name = "del_yn")
	private Boolean deleted;

	@ManyToOne
	@JoinColumn(name = "reg_user_no")
	private User registrant;

	@ManyToOne(optional = false)
	@JoinColumn(name = "content_no")
	private Content content;

	@Builder
	public ContentReply(String contents, User registrant, Content content) {
		this.contents = contents;
		this.registrant = registrant;
		this.content = content;
		this.deleted = false;
	}
}
