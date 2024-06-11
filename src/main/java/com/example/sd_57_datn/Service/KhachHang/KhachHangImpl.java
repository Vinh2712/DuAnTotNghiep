package com.example.sd_57_datn.Service.KhachHang;

import com.example.sd_57_datn.Model.KhachHang;
import com.example.sd_57_datn.Repository.KhachHangRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface KhachHangImpl {

  List<KhachHang> findAll();
  KhachHang getById(UUID id);
  KhachHang save(KhachHang khachHang);
  void delete(UUID id);
}