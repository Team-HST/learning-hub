package com.hst.learninghub.donation.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "content_don_org")
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ContentDonOrg {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ContentDonOrgPK pk;

    @Column(name = "del_yn")
    private Boolean deleted;

    @Column(name = "reg_user_no")
    private Long regUserNo;

    @CreatedDate
    @Column(name = "REG_DTM")
    private LocalDateTime createdAt;
}
