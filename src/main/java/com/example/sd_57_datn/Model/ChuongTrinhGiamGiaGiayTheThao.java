package com.example.sd_57_datn.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "ChuongTrinhGiamGiaGiayTheThao")
public class ChuongTrinhGiamGiaGiayTheThao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_ChuongTrinhGiamGiaGiayTheThao")
    private UUID id;

    @Column(name = "tenChuongTrinhGiamGia")
    private String tenChuongTrinhGiamGia;

    @Column(name = "phanTramGiam")
    private int phanTramGiam;

    @Column(name = "ngayBatDau")
    private String ngayBatDau;

    @Column(name = "ngayKetThuc")
    private String ngayKetThuc;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private String trangThai;


}
