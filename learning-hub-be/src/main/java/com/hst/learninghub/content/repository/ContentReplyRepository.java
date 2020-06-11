package com.hst.learninghub.content.repository;

import com.hst.learninghub.content.entity.ContentReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hyungyu.lee@nhn.com
 */
@Repository
public interface ContentReplyRepository extends JpaRepository<ContentReply, Long> {
}
