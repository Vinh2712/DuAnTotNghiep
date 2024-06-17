package com.example.sd_57_datn.Service.KhachHang;

import com.example.sd_57_datn.Model.KhachHang;
import com.example.sd_57_datn.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangService implements KhachHangImpl{

  @Autowired
  private KhachHangRepository khachHangRepository;

  public static void addKhachHang(KhachHang khachHang) {
  }
  public List<KhachHang> findAll(){
    return khachHangRepository.findAll();
  }

  @Override
  public KhachHang getById(UUID id) {
    return null;
  }

  @Override
  public KhachHang save(KhachHang khachHang) {
    return null;
  }

  @Override
  public void delete(UUID id) {

  }

  public KhachHang getKhachHangById(UUID id) {
    return khachHangRepository.findById(id).orElse(null);
  }

  public KhachHang saveKhachHang(KhachHang khachHang) {
    return khachHangRepository.save(khachHang);
  }

  public KhachHang addKhachhang(KhachHang khachHang) {
    return khachHangRepository.save(khachHang);
  }
//  List<KhachHang> getAll();
//  KhachHang getById(UUID id);
//  KhachHang save(KhachHang khachHang);
//  void delete(UUID id);


  //Todo code dành cho bán hàng tại quậy
  public List<KhachHang> getAll() {
    return khachHangRepository.findAll();
  }
}