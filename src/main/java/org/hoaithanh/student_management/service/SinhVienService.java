package org.hoaithanh.student_management.service;

import org.hoaithanh.student_management.entity.SinhVien;
import org.hoaithanh.student_management.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhViens() {
        return sinhVienRepository.findAll();
    }

    public Optional<SinhVien> getSinhVienById(Long id) {
        return sinhVienRepository.findById(id);
    }

    public SinhVien addSinhVien(SinhVien sinhVien) {
        return sinhVienRepository.save(sinhVien);
    }

    public void deleteSinhVien(Long id) {
        sinhVienRepository.deleteById(id);
    }
}

