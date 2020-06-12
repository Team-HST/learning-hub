package com.hst.learninghub.donation.entity;

import com.hst.learninghub.content.entity.Content;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="cont_donation")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ContDonation {
    private static final long serialVersionUID = 1L;

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
    private Long donUserNo;

    @CreatedDate
    @Column(name = "don_dtm")
    private LocalDateTime don_dtm;

    public boolean isValid() {
        if (this.donationNo == null || this.contentNo == null || this.amount == null) {
            return false;
        }
        return true;
    }

    public void successCalculate(Long calculateNo) {
        this.calculateNo = calculateNo;
    }
}
