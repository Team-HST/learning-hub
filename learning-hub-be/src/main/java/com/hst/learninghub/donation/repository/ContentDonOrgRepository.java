package com.hst.learninghub.donation.repository;

import com.hst.learninghub.donation.entity.ContentDonOrg;
import com.hst.learninghub.donation.entity.ContentDonOrgPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentDonOrgRepository extends JpaRepository<ContentDonOrg, ContentDonOrgPK> {

	@Query("select cdo from ContentDonOrg cdo" +
		   " where cdo.pk.contentNo = :contentNo")
	List<ContentDonOrg> findAllContentDonationOrgs(Long contentNo);

}
