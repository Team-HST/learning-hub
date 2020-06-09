package com.hst.learninghub.donation.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="cont_donation")
@ToString
@Builder
@NoArgsConstructor
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

    @Column(name = "don_dtm")
    private LocalDateTime don_dtm;
}
