package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}
