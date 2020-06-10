package com.hst.learninghub.donation.repository;

import com.hst.learninghub.donation.entity.ContentDonOrg;
import com.hst.learninghub.donation.entity.ContentDonOrgPK;
import com.hst.learninghub.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentDonOrgRepository extends JpaRepository<ContentDonOrg, ContentDonOrgPK> {

}
