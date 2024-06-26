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
@Table(name = "DayGiay")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayGiay {
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
@Table(name = "DayGiay")
public class DayGiay {

>>>>>>> Stashed changes
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_DayGiay")
    private UUID id;

<<<<<<< Updated upstream
=======
    @NotBlank(message = "Không được để trống")
>>>>>>> Stashed changes
    @Column(name = "tenDayGiay")
    private String tenDayGiay;

    @Column(name = "chieuDaiDayGiay")
    private String chieuDaiDayGiay;

<<<<<<< Updated upstream
    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private int trangThai;
=======
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
