package com.example.sd_57_datn.Service.HoaDon;

import com.example.sd_57_datn.Model.HoaDon;
import java.util.List;
import java.util.UUID;

public interface HoaDonImpl {

  public abstract HoaDon save(HoaDon hoaDon);

  HoaDon findById(UUID id);

  List<HoaDon> findAll();
}
