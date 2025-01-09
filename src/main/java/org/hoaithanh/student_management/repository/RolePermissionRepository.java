package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.Course;
import org.hoaithanh.student_management.entity.RolePermission;
import org.hoaithanh.student_management.entity.RolePermissionId;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionId> {
}