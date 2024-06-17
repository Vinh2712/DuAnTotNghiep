package com.example.sd_57_datn.Service.GiayTheThao;

import com.example.sd_57_datn.Model.GiayTheThaoChiTiet;

import java.util.UUID;

public interface GiayTheThaoChiTietImpl {
    GiayTheThaoChiTiet findIdByIdGiayTheThao(UUID id, UUID idMauSac, UUID idSize);
}
