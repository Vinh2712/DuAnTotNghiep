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
@Table(name = "DeGiay")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeGiay {
=======

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "DeGiay")
public class DeGiay {

>>>>>>> Stashed changes
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_DeGiay")
    private UUID id;

    @Column(name = "tenDeGiay")
    private String tenDeGiay;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "ngayTao")
<<<<<<< Updated upstream
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private int trangThai;
=======
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;

>>>>>>> Stashed changes
}
