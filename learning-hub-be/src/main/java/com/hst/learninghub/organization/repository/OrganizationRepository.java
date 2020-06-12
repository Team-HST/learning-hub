package com.hst.learninghub.organization.repository;

import com.hst.learninghub.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
