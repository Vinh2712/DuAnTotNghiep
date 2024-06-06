package com.example.sd_57_datn.Service.Giay;


import com.example.sd_57_datn.Model.DeGiay;
import com.example.sd_57_datn.Model.KieuBuoc;
import com.example.sd_57_datn.Repository.Giay.DeGiayRepository;
import com.example.sd_57_datn.Repository.Giay.KieuBuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KieuBuocService {

    @Autowired
    private KieuBuocRepository kieuBuocRepository;



    public void add(KieuBuoc kieuBuoc) {
        this.kieuBuocRepository.save(kieuBuoc);
    }


    public void update(KieuBuoc kieuBuoc, UUID id) {
        KieuBuoc kieuBuoc1 = this.kieuBuocRepository.findById(id).get();
        kieuBuoc1.setTenKieuBuoc(kieuBuoc.getTenKieuBuoc());
        kieuBuoc1.setGhiChu(kieuBuoc.getGhiChu());
        kieuBuoc1.setNgayTao(kieuBuoc.getNgayTao());
        kieuBuoc1.setNgaySua(kieuBuoc.getNgaySua());
        kieuBuoc1.setTrangThai(kieuBuoc.getTrangThai());
        this.kieuBuocRepository.save(kieuBuoc);
    }

//    @Override
//    public void delete(UUID id) {
//        DeGiay deGiay = repo.findById(id).get();
//        repo.delete(deGiay);
//    }

    public Page<KieuBuoc> search(Pageable pageable, String name) {

        return this.kieuBuocRepository.findByTenKieuBuocContaining(name, pageable);
    }


    public Page<KieuBuoc> pagination(Pageable pageable) {
        return this.kieuBuocRepository.findAll(pageable);
    }


}
