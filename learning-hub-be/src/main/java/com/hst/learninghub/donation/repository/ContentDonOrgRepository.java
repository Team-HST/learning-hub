package com.hst.learninghub.donation.repository;

import com.hst.learninghub.donation.entity.ContentDonationOrg;
import com.hst.learninghub.donation.entity.ContentDonationOrgId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentDonOrgRepository extends JpaRepository<ContentDonationOrg, ContentDonationOrgId> {

	@Query("select cdo from ContentDonationOrg cdo" +
		   " where cdo.id.contentNo = :contentNo")
	List<ContentDonationOrg> findAllContentDonationOrgs(Long contentNo);

}
