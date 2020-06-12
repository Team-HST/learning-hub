package com.hst.learninghub.user.repository;

import com.hst.learninghub.user.entity.UserReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserReceiptRepository extends JpaRepository<UserReceipt, Long> {
    @Query("select SUM(UR.amount) from UserReceipt UR " +
            "where UR.regUser.no = :userNo " +
            "group by UR.regUser.no")
    Long findTotReceiptAmountByUserNo(Long userNo);
}
