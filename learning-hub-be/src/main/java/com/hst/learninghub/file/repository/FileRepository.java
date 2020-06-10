package com.hst.learninghub.file.repository;

import com.hst.learninghub.file.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public interface FileRepository extends JpaRepository<FileInfo, Long> {
}
