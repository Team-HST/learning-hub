package com.hst.learninghub.donation.repository;

import com.hst.learninghub.donation.entity.OrgDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrgDonationRepository extends JpaRepository<OrgDonation, Long> {

    @Query("select CD from OrgDonation CD " +
           " where CD.calculateNo is null " +
           "   and CD.donationAt between ?1 and ?2")
    List<OrgDonation> findByNotCalculatedDonations(LocalDateTime startAt, LocalDateTime endAt);

    List<OrgDonation> findAllByOrganizationNo(Long orgNo);
}
