package com.example.sd_57_datn.Model;

<<<<<<< Updated upstream
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "CongDung")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CongDung {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "Id_CongDung")
    private UUID id;

    @Column(name = "tenCongDung")
    private String tenCongDung;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private int trangThai;
=======

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "CongDung")
public class CongDung {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_CongDung")
    private UUID id;

    @NotBlank(message = "Không được để trống")
    @Column(name = "tenCongDung")
    private String tenCongDung;

    @NotBlank(message = "Không được để trống")
    @Column(name = "ghiChu")
    private String ghiChu;

    @NotBlank(message = "Không được để trống")
    @Column(name = "ngayTao")
    private String ngayTao;

    @NotBlank(message = "Không được để trống")
    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;

>>>>>>> Stashed changes
}
