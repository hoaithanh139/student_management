package org.hoaithanh.student_management.repository;

import org.hoaithanh.student_management.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
    SinhVien getSinhVienById(Long id);
}
