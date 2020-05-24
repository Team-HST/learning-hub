package com.hst.learninghub.user.entity;

import com.hst.learninghub.common.entity.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "USER")
@Getter
public class User extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_NO")
	private Long no;

	@Column(name = "USER_ID")
	private String id;

	@Column(name = "USER_NM")
	private String name;

	@Column(name = "USER_BIRTH")
	private LocalDateTime birthDate;

	@Column(name = "USER_ROLE_CD")
	private String roleType;

	@Column(name = "USER_JOIN_CD")
	private String joinType;

	@Column(name = "DEL_YN")
	private boolean deleted;
}
