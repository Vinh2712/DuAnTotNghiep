package com.example.sd_57_datn.Service.Giay;

import com.example.sd_57_datn.Model.HuongDanBaoQuan;
import com.example.sd_57_datn.Repository.Giay.HuongDanBaoQuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuongDanBaoQuanService {

    @Autowired
    private HuongDanBaoQuanRepository huongDanBaoQuanRepository;

    public List<HuongDanBaoQuan> findHuongDanBaoQuan(String tenHuongDanBaoQuan) {
        if (tenHuongDanBaoQuan != null) {
            return huongDanBaoQuanRepository.findByTenHuongDanBaoQuanContaining(tenHuongDanBaoQuan);
        } else {
            return huongDanBaoQuanRepository.findAll();
        }
    }

}
