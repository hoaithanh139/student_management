package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
