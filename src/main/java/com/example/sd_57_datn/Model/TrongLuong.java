package com.example.sd_57_datn.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TrongLuong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrongLuong {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_TrongLuong")
    private UUID id;

    @Column(name = "tenTrongLuong")
    private String tenTrongLuong;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;
}
