package com.example.sd_57_datn.Service;

import com.example.sd_57_datn.Model.HoaDonChiTiet;
import com.example.sd_57_datn.Repository.HoaDon.HoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietService {
  @Autowired
  private HoaDonChiTietRepository hoaDonChiTietRepository;

  public HoaDonChiTiet save(HoaDonChiTiet hoaDonChiTiet) {
    return hoaDonChiTietRepository.save(hoaDonChiTiet);
  }

  public HoaDonChiTiet findById(UUID id) {
    return hoaDonChiTietRepository.findById(id).orElse(null);
  }

  public List<HoaDonChiTiet> findAll() {
    return hoaDonChiTietRepository.findAll();
  }

  public List<HoaDonChiTiet> findByHoaDonId(UUID hoaDonId) {
    return hoaDonChiTietRepository.findByHoaDon_Id(hoaDonId);
  }
}
