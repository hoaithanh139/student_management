package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
