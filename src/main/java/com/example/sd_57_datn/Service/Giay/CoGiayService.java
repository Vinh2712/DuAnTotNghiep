package com.example.sd_57_datn.Service.Giay;

import com.example.sd_57_datn.Model.CoGiay;
import com.example.sd_57_datn.Repository.Giay.CoGiayRepository;
import com.example.sd_57_datn.Repository.Giay.CoGiayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CoGiayService {

    @Autowired
    private CoGiayRepository coGiayRepository;

    public List<CoGiay> findCoGiay(String tenCoGiay) {
        if (tenCoGiay != null) {
            return coGiayRepository.findByTenCoGiayContaining(tenCoGiay);
        } else {
            return coGiayRepository.findAll();
        }
    }
}
