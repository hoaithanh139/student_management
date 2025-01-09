package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.ClassTutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassTutorial, Integer> {
}
