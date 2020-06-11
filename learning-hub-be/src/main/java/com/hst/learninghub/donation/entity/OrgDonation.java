package com.hst.learninghub.donation.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="cont_donation")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrgDonation {
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

        @Column(name = "reg_user_no")
        private Long regUserNo;

        @Column(name = "reg_dtm")
        private LocalDateTime reg_dtm;

        @Column(name = "org_no")
        private Long orgNo;

        public boolean isValid() {
            if (this.donationNo == null || this.orgNo == null || this.amount == null || this.contentNo == null) {
                return false;
            }
            return true;
        }
}
