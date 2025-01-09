package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
