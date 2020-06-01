package com.hst.learninghub.calculate.repository;

import com.hst.learninghub.calculate.entity.Calculate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CalculateRepository extends JpaRepository<Calculate, Long>, JpaSpecificationExecutor<Calculate> {
}
