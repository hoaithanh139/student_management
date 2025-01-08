package org.hoaithanh.student_management.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class SinhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Khóa chính, tự động tăng

    @Column(name = "ma_sinh_vien", nullable = false, unique = true)
    private String maSinhVien; // Mã sinh viên

    @Column(name = "ho_ten", nullable = false)
    private String hoTen; // Họ tên sinh viên

    @Column(name = "ngay_sinh", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngaySinh; // Ngày sinh

    @Column(name = "gioi_tinh", nullable = false)
    private String gioiTinh; // Giới tính

    @Column(name = "dia_chi")
    private String diaChi; // Địa chỉ

    @Column(name = "email", unique = true)
    private String email; // Địa chỉ email

    @Column(name = "so_dien_thoai")
    private String soDienThoai; // Số điện thoại

    // Constructor không tham số
    public SinhVien() {
    }

    // Constructor có tham số
    public SinhVien(String maSinhVien, String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String email, String soDienThoai) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }


    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", maSinhVien='" + maSinhVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh=" + gioiTinh +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}

