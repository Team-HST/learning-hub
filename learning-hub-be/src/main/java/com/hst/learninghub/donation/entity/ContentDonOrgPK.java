package com.hst.learninghub.donation.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@ToString
@Getter
public class ContentDonOrgPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "content_no")
    private Long contentNo;

    @Column(name = "donation_org_no")
    private Long orgNo;

    public static ContentDonOrgPK of(Long contentNo, Long orgNo) {
        ContentDonOrgPK pk = new ContentDonOrgPK();
        pk.contentNo = contentNo;
        pk.orgNo = orgNo;
        return pk;
    }
}
