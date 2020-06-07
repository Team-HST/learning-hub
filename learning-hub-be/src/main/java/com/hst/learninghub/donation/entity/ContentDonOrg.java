package com.hst.learninghub.donation.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "content_don_org")
@Getter
@ToString
@NoArgsConstructor
public class ContentDonOrg {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ContentDonOrgPK contentDonOrgPK;

    @Column(name = "del_yn")
    private String delYn;

    @Column(name = "reg_user_no")
    private Long regUserNo;
}
