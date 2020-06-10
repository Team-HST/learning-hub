package com.hst.learninghub.calculate.repository;

import com.hst.learninghub.calculate.entity.Calculate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CalculateRepository extends JpaRepository<Calculate, Long>, JpaSpecificationExecutor<Calculate> {
    @Query("select MAX(C.no) from Calculate C")
    Calculate findMaxId();
}
