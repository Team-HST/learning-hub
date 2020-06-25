package com.hst.learninghub.donation.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "org_donation")
@ToString
@NoArgsConstructor
public class OrgDonation extends Donation {

	@Column(name = "org_no")
	private Long organizationNo;

	public OrgDonation(Long contentNo, Long amount, Long donationUserNo, Long organizationNo) {
		super(contentNo, amount, donationUserNo);
	}

}
