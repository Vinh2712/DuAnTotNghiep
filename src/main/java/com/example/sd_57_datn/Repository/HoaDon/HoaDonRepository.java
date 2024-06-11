package com.example.sd_57_datn.Repository.HoaDon;

import com.example.sd_57_datn.Model.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {

  @Query("select hd from HoaDon hd where hd.khachHang.id = ?1 and hd.trangThai = ?2")
  Page<HoaDon> listHoaDonFindByKhachHangAndTrangThai(UUID idKhachHang, int trangThai, Pageable pageable);

  @Query("select hd from HoaDon hd where hd.trangThai = ?1")
  Page<HoaDon> listHoaDonFindByTrangThai(int trangThai, Pageable pageable);
}
