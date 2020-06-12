package com.hst.learninghub.donation.repository;

import com.hst.learninghub.donation.entity.ContDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentDonRepository extends JpaRepository<ContDonation, Long> {

    @Query("select CD from ContDonation CD " +
            "where CD.calculateNo IS NULL")
    List<ContDonation> findByNullToCalculateNo();

    @Query("select CD " +
           " from ContDonation CD" +
           " where CD.contentNo in :contentNoList")
    List<ContDonation> findAllByContentUserNo(List<Long> contentNoList);

    @Query("select SUM(CD.amount) " +
           " from ContDonation CD " +
           " where CD.donUserNo = :userNo" +
           " group by CD.donUserNo")
    Long findSumAmountByDonUserNo(Long userNo);
}
