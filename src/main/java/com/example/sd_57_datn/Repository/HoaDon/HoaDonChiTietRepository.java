package com.example.sd_57_datn.Repository.HoaDon;

import com.example.sd_57_datn.Model.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, UUID> {
  List<HoaDonChiTiet> findByHoaDon_Id(UUID hoaDonId);
}
