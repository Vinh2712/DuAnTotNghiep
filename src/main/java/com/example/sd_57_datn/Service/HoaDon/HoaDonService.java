package com.example.sd_57_datn.Service.HoaDon;

import com.example.sd_57_datn.Model.HoaDon;
import com.example.sd_57_datn.Repository.GiayTheThao.GiayTheThaoChiTietRepository;
import com.example.sd_57_datn.Repository.HoaDon.HoaDonChiTietRepository;
import com.example.sd_57_datn.Repository.HoaDon.HoaDonRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonService implements HoaDonImpl{
  @Autowired
  private HoaDonChiTietRepository hoaDonChiTietRepository;

  @Autowired
  private HoaDonRepository hoaDonRepository;

  @Autowired
  private GiayTheThaoChiTietRepository giayTheThaoChiTietRepository;

  @Override
  public HoaDon save(HoaDon hoaDon) {
    return hoaDonRepository.save(hoaDon);
  }
  @Override
  public HoaDon findById(UUID id) {
    return hoaDonRepository.findById(id).orElse(null);
  }
  @Override
  public List<HoaDon> findAll() {
    return hoaDonRepository.findAll();
  }
}
