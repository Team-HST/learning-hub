package com.hst.learninghub.user.repository;

import com.hst.learninghub.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(String id);
}
