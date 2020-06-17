package com.hst.learninghub.donation.repository;

import com.hst.learninghub.donation.entity.ContentDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentDonRepository extends JpaRepository<ContentDonation, Long> {

    @Query("select CD from ContentDonation CD " +
            "where CD.calculateNo IS NULL")
    List<ContentDonation> findByNullToCalculateNo();
}
