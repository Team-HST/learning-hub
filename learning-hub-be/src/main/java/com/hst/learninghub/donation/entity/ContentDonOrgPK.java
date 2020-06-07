package com.hst.learninghub.donation.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@ToString
public class ContentDonOrgPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long contentNo;
    private Long orgNo;
}
