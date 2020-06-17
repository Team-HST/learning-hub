package com.hst.learninghub.donation.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@ToString
@Getter
public class ContentDonationOrgId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "content_no")
    private Long contentNo;

    @Column(name = "donation_org_no")
    private Long orgNo;

    public static ContentDonationOrgId of(Long contentNo, Long orgNo) {
        ContentDonationOrgId pk = new ContentDonationOrgId();
        pk.contentNo = contentNo;
        pk.orgNo = orgNo;
        return pk;
    }
}
