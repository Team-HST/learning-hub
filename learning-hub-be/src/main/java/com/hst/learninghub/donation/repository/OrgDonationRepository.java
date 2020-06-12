package com.hst.learninghub.donation.repository;

import com.hst.learninghub.donation.entity.OrgDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrgDonationRepository extends JpaRepository<OrgDonation, Long> {

    @Query("select OD from OrgDonation OD " +
            "where OD.calculateNo IS NULL")
    List<OrgDonation> findByNullToCalculateNo();
}
