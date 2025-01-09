package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.StudentCourse;
import org.hoaithanh.student_management.entity.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {
}
