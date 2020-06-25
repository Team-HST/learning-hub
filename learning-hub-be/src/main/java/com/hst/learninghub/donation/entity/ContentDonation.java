package com.hst.learninghub.donation.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name="cont_donation")
@ToString
@NoArgsConstructor
public class ContentDonation extends Donation {

    public ContentDonation(Long contentNo, Long amount, Long donationUserNo) {
        super(contentNo, amount, donationUserNo);
    }

}
