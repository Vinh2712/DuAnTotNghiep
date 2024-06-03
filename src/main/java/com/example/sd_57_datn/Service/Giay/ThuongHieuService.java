package com.example.sd_57_datn.Service.Giay;

import com.example.sd_57_datn.Model.ThuongHieu;
import com.example.sd_57_datn.Repository.Giay.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ThuongHieuService {

    @Autowired
    private ThuongHieuRepository repo;


    public void add(ThuongHieu th) {
        this.repo.save(th);
    }


    public void update(ThuongHieu th, UUID id) {
        ThuongHieu thuongHieu = this.repo.findById(id).get();
        thuongHieu.setTenThuongHieu(th.getTenThuongHieu());
        thuongHieu.setGhiChu(th.getGhiChu());
        thuongHieu.setNgayTao(th.getNgayTao());
        thuongHieu.setNgaySua(th.getNgaySua());
        thuongHieu.setTrangThai(th.getTrangThai());
        this.repo.save(thuongHieu);
    }

//    @Override
//    public void delete(UUID id) {
//        ThuongHieu th = this.repo.findById(id).get();
//        this.repo.delete(th);
//    }


    public Page<ThuongHieu> search(Pageable pageable, String name) {
        return this.repo.findByTenThuongHieuContaining(name, pageable);
    }


    public Page<ThuongHieu> pagination(Pageable pageable) {
        return this.repo.findAll(pageable);
    }

}
