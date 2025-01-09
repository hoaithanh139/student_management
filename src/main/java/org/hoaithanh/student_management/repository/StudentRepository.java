package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByUserUsername(String username);
}
