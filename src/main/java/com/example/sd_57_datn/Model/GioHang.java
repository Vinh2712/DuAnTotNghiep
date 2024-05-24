package com.example.sd_57_datn.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "GioHang")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_GioHang")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "Id_User")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "Id_KhachHang")
    private KhachHang khachHang;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private int trangThai;
}
