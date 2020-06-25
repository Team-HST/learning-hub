package com.hst.learninghub.donation.repository;

import com.hst.learninghub.donation.entity.ContentDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ContentDonationRepository extends JpaRepository<ContentDonation, Long> {

    @Query("select CD from ContentDonation CD " +
           " where CD.calculateNo is null " +
           "   and CD.donationAt between ?1 and ?2")
    List<ContentDonation> findByNotCalculatedDonations(LocalDateTime startAt, LocalDateTime endAt);

}
