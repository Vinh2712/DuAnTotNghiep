package com.example.sd_57_datn.Service.Giay;

import com.example.sd_57_datn.Repository.Giay.LotGiayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotGiayService {
    @Autowired
    private LotGiayRepository lotGiayRepository;
}
