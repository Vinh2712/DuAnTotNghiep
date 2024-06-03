package com.example.sd_57_datn.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "KieuBuoc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class KieuBuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_KieuBuoc")
    private UUID id;

    @Column(name = "tenKieuBuoc")
    private String tenKieuBuoc;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;


}
