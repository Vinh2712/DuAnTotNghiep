package com.example.sd_57_datn.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PhieuGiamGiaHoaDonChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PhieuGiamGiaHoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_PhieuGiamGiaHoaDonChiTiet")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "Id_PhieuGiamGiaHoaDon")
    private PhieuGiamGiaHoaDon idPhieuGiamGiaHoaDon;

    @ManyToOne
    @JoinColumn(name = "Id_HoaDon")
    private HoaDon idHoaDon;

    @Column(name = "tenPhieuGiamGiaHoaDonChiTiet")
    private String tenkieuBuoc;

    @Column(name = "soTienHoaDonDaGiam")
    private BigDecimal soTienHoaDonDaGiam;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private int trangThai;


}
