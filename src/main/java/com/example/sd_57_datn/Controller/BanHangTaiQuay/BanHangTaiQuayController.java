package com.example.sd_57_datn.Controller.BanHangTaiQuay;

import com.example.sd_57_datn.Model.GiayTheThao;
import com.example.sd_57_datn.Model.GiayTheThaoChiTiet;
import com.example.sd_57_datn.Model.HoaDon;
import com.example.sd_57_datn.Model.HoaDonChiTiet;
import com.example.sd_57_datn.Model.KhachHang;
import com.example.sd_57_datn.Model.MauSac;
import com.example.sd_57_datn.Model.Size;
import com.example.sd_57_datn.Service.GiayTheThao.GiayTheThaoChiTietService;
import com.example.sd_57_datn.Service.GiayTheThao.GiayTheThaoService;
import com.example.sd_57_datn.Service.Giay.MauSacService;
import com.example.sd_57_datn.Service.Giay.SizeService;
import com.example.sd_57_datn.Service.HoaDon.HoaDonService;
import com.example.sd_57_datn.Service.HoaDon.HoaDonChiTietService;
import com.example.sd_57_datn.Service.KhachHang.KhachHangService;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("BanHangTaiQuay")
public class BanHangTaiQuayController {


  @Autowired
  private GiayTheThaoChiTietService gttctService;

  @Autowired
  private HoaDonService hoaDonService;

  @Autowired
  private HoaDonChiTietService hoaDonChiTietService;

  @Autowired
  private KhachHangService khachHangService;



  @GetMapping()
  public String getView(Model model) {


    model.addAttribute("listSP", gttctService.getAll());
    System.out.println(gttctService.getAll());
    model.addAttribute("listHDC", hoaDonService.hoaDonCho());
    model.addAttribute("listKH", khachHangService.getAll());

    return "BanHangTaiQuay/BanHangTaiQuayTest";

  }

  @GetMapping("thanhToan/{id}")
  public String getViewPay(Model model, @PathVariable("id") UUID id, HttpSession session) {

    UUID idUser = (UUID) session.getAttribute("idUser");

    // Kiểm tra idUser có tồn tại
    if (idUser != null) {
      // Thực hiện lưu idUser vào hóa đơn
      hoaDonService.luuIdUserVaoHoaDon(id, idUser);

      List<HoaDonChiTiet> listHDCT = hoaDonChiTietService.getListByID(id);
      int sl = 0;
      BigDecimal tt = new BigDecimal(0);
      for (HoaDonChiTiet hoaDonChiTiet : listHDCT) {
        sl+=Integer.parseInt(hoaDonChiTiet.getSoLuong());
        BigDecimal soLuong = new BigDecimal(hoaDonChiTiet.getSoLuong());
        tt = tt.add(hoaDonChiTiet.getDonGia().multiply(soLuong));
      }
      model.addAttribute("list", listHDCT);
      model.addAttribute("tt", tt);
     model.addAttribute("id", id);

      return "BanHangTaiQuay/thanhToan";


    }else {

      return null;

    }

  }

}
