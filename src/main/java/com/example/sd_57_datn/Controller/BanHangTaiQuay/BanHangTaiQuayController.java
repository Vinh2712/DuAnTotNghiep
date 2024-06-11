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
import com.example.sd_57_datn.Service.HoaDonChiTietService;
import com.example.sd_57_datn.Service.KhachHang.KhachHangService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/BanHangTaiQuay")
public class BanHangTaiQuayController {

  @Autowired
  private GiayTheThaoChiTietService giayTheThaoChiTietService;

  @Autowired
  private GiayTheThaoService giayTheThaoService;

  @Autowired
  private MauSacService mauSacService;

  @Autowired
  private SizeService sizeService;

  @Autowired
  private KhachHangService khachHangService;
  @Autowired
  private HoaDonService hoaDonService;

  @Autowired
  private HoaDonChiTietService hoaDonChiTietService;
  @GetMapping
  public String listBHTQ(Model model) {
    List<GiayTheThaoChiTiet> bhtqList = giayTheThaoChiTietService.getAll();
    List<KhachHang> listKhachHang = khachHangService.findAll();
    model.addAttribute("bhtqList", bhtqList);
    model.addAttribute("listKhachHang", listKhachHang);
    return "BanHangTaiQuay/index";
  }

  @GetMapping("/addgtt")
  public String addForm(Model model) {
    model.addAttribute("giayTheThaoChiTiet", new GiayTheThaoChiTiet());
    return "BanHangTaiQuay/addgtt";
  }

  @PostMapping("/addgtt")
  public String addSubmit(@ModelAttribute GiayTheThaoChiTiet giayTheThaoChiTiet) {
    // Lưu các đối tượng liên quan trước
    GiayTheThao giayTheThao = giayTheThaoService.save(giayTheThaoChiTiet.getGiayTheThao());
    MauSac mauSac = mauSacService.save(giayTheThaoChiTiet.getMauSac());
    Size size = sizeService.save(giayTheThaoChiTiet.getSize());

    giayTheThaoChiTiet.setGiayTheThao(giayTheThao);
    giayTheThaoChiTiet.setMauSac(mauSac);
    giayTheThaoChiTiet.setSize(size);

    giayTheThaoChiTietService.save(giayTheThaoChiTiet);
    return "redirect:/BanHangTaiQuay";
  }

  @GetMapping("/detail/{id}")
  public String viewDetail(@PathVariable("id") UUID id, Model model) {
    GiayTheThaoChiTiet giayTheThaoChiTiet = giayTheThaoChiTietService.getById(id);
    if (giayTheThaoChiTiet == null) {
      return "redirect:/BanHangTaiQuay";
    }
    model.addAttribute("giayTheThaoChiTiet", giayTheThaoChiTiet);
    return "BanHangTaiQuay/detail";
  }
  @PostMapping("/updatesl")
  public String updateQuantity(@RequestParam("id") UUID id, @RequestParam("soLuong") String soLuong) {
    GiayTheThaoChiTiet giayTheThaoChiTiet = giayTheThaoChiTietService.getById(id);
    giayTheThaoChiTiet.setSoLuong(soLuong);
    giayTheThaoChiTietService.save(giayTheThaoChiTiet);

    return "redirect:/BanHangTaiQuay/detail/" + id;
  }

  @GetMapping("/khachhang")
  public String listKhachHang(Model model) {
    List<KhachHang> khachHangList = khachHangService.findAll();
    model.addAttribute("listKhachHang", khachHangList);
    return "BanHangTaiQuay/khachhang";
  }

  @GetMapping("/addkh")
  public String showAddCustomerForm(Model model) {
    model.addAttribute("khachHang", new KhachHang());
    return "BanHangTaiQuay/addkh";
  }

  @PostMapping("/addkh")
  public String addCustomer(@ModelAttribute KhachHang khachHang) {
    khachHangService.save(khachHang);
    return "redirect:/BanHangTaiQuay/khachhang";
  }
  @GetMapping("/thanhtoan")
  public String thanhToanForm(Model model) {
    List<KhachHang> listKhachHang = khachHangService.findAll();
    List<GiayTheThaoChiTiet> listGiay = giayTheThaoChiTietService.getAll();
    model.addAttribute("listKhachHang", listKhachHang);
    model.addAttribute("listGiay", listGiay);
    model.addAttribute("hoaDon", new HoaDon());
    return "BanHangTaiQuay/thanhtoan";
  }

  @PostMapping("/thanhtoan")
  public String thanhToan(@ModelAttribute HoaDon hoaDon, @RequestParam("giayTheThaoChiTietIds") List<UUID> giayTheThaoChiTietIds, @RequestParam("soLuongs") List<Integer> soLuongs) {
    hoaDon.setNgayTao(LocalDateTime.now());
    hoaDonService.save(hoaDon);

    for (int i = 0; i < giayTheThaoChiTietIds.size(); i++) {
      UUID giayId = giayTheThaoChiTietIds.get(i);
      int soLuong = soLuongs.get(i);

      GiayTheThaoChiTiet giayTheThaoChiTiet = giayTheThaoChiTietService.getById(giayId);
      double donGia = Double.parseDouble(giayTheThaoChiTiet.getGiayTheThao().getGiaBan());

      HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
      hoaDonChiTiet.setHoaDon(hoaDon);
      hoaDonChiTiet.setGiayTheThaoChiTiet(giayTheThaoChiTiet);
      hoaDonChiTiet.setSoLuong(String.valueOf(soLuong));
      hoaDonChiTiet.setDonGia(BigDecimal.valueOf(donGia));

      hoaDonChiTietService.save(hoaDonChiTiet);
    }

    return "redirect:/BanHangTaiQuay/hoadon/" + hoaDon.getId();
  }

  @GetMapping("/hoadon")
  private String vHoaDon(Model model){
    List<HoaDon> listHoaDon = hoaDonService.findAll();
    model.addAttribute("listHoaDon", listHoaDon);
    return "BanHangTaiQuay/hoadon";
  }

  @GetMapping("/hoadon/{id}")
  public String viewHoaDon(@PathVariable("id") UUID id, Model model) {
    HoaDon hoaDon = hoaDonService.findById(id);
    if (hoaDon == null) {
      return "redirect:/BanHangTaiQuay";
    }
    List<HoaDonChiTiet> chiTietList = hoaDonChiTietService.findByHoaDonId(id);
    model.addAttribute("hoaDon", hoaDon);
    model.addAttribute("chiTietList", chiTietList);
    return "BanHangTaiQuay/hoadon";
  }
}
