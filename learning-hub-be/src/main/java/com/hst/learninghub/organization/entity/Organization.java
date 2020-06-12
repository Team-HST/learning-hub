package com.hst.learninghub.organization.entity;

import com.hst.learninghub.common.entity.BaseTimeEntity;
import com.hst.learninghub.file.entity.FileInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author dlgusrb0808@gmail.com
 */
@Entity
@Table(name = "organization")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Organization extends BaseTimeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "donation_org_no")
	private Long no;

	@Column(name = "donation_org_nm")
	private String name;

	@Column(name = "donation_org_addr")
	private String address;

	@Column(name = "org_phn_no")
	private String phoneNumber;

	@Column(name = "del_yn")
	private boolean deleted;

	@Column(name = "reg_user_no")
	private Long registrantUserNo;

	@OneToOne
	@JoinColumn(name = "thumb_file_no")
	private FileInfo thumbnail;
}
