package com.example.sd_57_datn.Service.Giay;

import com.example.sd_57_datn.Model.GiayTheThao;
import com.example.sd_57_datn.Model.MauSac;
import com.example.sd_57_datn.Repository.Giay.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    public MauSac save(MauSac mauSac) {
        return mauSacRepository.save(mauSac);
    }

    public List<MauSac> findMauSac(String tenMauSac) {
        if (tenMauSac != null) {
            return mauSacRepository.findByTenMauSac(tenMauSac);
        } else {
            return mauSacRepository.findAll();
        }
    }

}
