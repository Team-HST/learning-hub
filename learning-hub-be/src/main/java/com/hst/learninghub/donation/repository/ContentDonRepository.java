package com.hst.learninghub.donation.repository;

import com.hst.learninghub.donation.entity.ContDonation;
import com.hst.learninghub.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentDonRepository extends JpaRepository<ContDonation, Long> {

    @Query("select CD from ContDonation CD " +
            "where CD.calculateNo IS NULL")
    List<ContDonation> findByNullToCalculateNo();
}
