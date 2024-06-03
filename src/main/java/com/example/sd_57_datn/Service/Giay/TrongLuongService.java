package com.example.sd_57_datn.Service.Giay;

import com.example.sd_57_datn.Model.DeGiay;
import com.example.sd_57_datn.Model.TrongLuong;
import com.example.sd_57_datn.Repository.Giay.DeGiayRepository;
import com.example.sd_57_datn.Repository.Giay.TrongLuongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrongLuongService {

    @Autowired
    private TrongLuongRepository repo;



    public void add(TrongLuong deGiay) {
        this.repo.save(deGiay);
    }


    public void update(TrongLuong deGiay, UUID id) {
        TrongLuong deGiay1 = this.repo.findById(id).get();
        deGiay1.setTenTrongLuong(deGiay.getTenTrongLuong());
        deGiay1.setGhiChu(deGiay.getGhiChu());
        deGiay1.setNgayTao(deGiay.getNgayTao());
        deGiay1.setNgaySua(deGiay.getNgaySua());
        deGiay1.setTrangThai(deGiay.getTrangThai());
        this.repo.save(deGiay1);
    }

//    @Override
//    public void delete(UUID id) {
//        DeGiay deGiay = repo.findById(id).get();
//        repo.delete(deGiay);
//    }

    public Page<TrongLuong> search(Pageable pageable, String name) {

        return this.repo.findByTenTrongLuongContainingOrderById(name,pageable);
    }


    public Page<TrongLuong> pagination(Pageable pageable) {
        return this.repo.findAll(pageable);
    }


}
