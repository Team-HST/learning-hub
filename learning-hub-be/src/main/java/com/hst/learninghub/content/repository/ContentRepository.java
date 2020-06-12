package com.hst.learninghub.content.repository;

import com.hst.learninghub.content.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public interface ContentRepository extends JpaRepository<Content, Long>, JpaSpecificationExecutor<Content> {
    @Query("select C.no " +
           "from Content C " +
           "where C.registrant.no = :userNo")
    List<Long> findIdByUserNo(Long userNo);
}
