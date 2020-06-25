package com.hst.learninghub.donation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Donation {
	@Id
	@Column(name = "donation_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donationNo;

	@Column(name = "content_no")
	private Long contentNo;

	@Column(name = "amount")
	private Long amount;

	@Column(name = "calculate_no")
	private Long calculateNo;

	@Column(name = "don_user_no")
	private Long donationUserNo;

	@CreatedDate
	@Column(name = "don_dtm")
	private LocalDateTime donationAt;

	public Donation() {
	}

	public Donation(Long contentNo, Long amount, Long donationUserNo) {
		this.contentNo = contentNo;
		this.amount = amount;
		this.donationUserNo = donationUserNo;
	}

	public boolean isValid() {
		return !(this.donationNo == null || this.contentNo == null || this.amount == null);
	}

	public void markCalculateNo(Long calculateNo) {
		this.calculateNo = calculateNo;
	}
}
