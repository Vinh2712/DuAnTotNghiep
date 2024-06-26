package com.example.sd_57_datn.Model;

import jakarta.persistence.*;
<<<<<<< Updated upstream
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table (name = "Form")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Form {
   @Id
    @GeneratedValue(strategy = GenerationType.UUID)
   @Column(name = "Id_Form")
    private UUID id;

   @Column(name = "tenForm")
    private String tenForm;

   @Column(name = "ghiChu")
    private String ghiChu;

   @Column(name = "ngayTao")
    private Date ngayTao;

   @Column(name = "ngaySua")
    private Date ngaySua;

   @Column(name = "trangThai")
=======
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Form")
public class Form{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_Form")
    private UUID id;

    @NotBlank(message = "Không được để trống")
    @Column(name = "tenForm")
    private  String tenForm	;

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
>>>>>>> Stashed changes
    private int trangThai;

}
