package com.example.sd_57_datn.Repository.Giay;

import com.example.sd_57_datn.Model.DeGiay;
import com.example.sd_57_datn.Model.KieuBuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KieuBuocRepository extends JpaRepository<KieuBuoc, UUID> {

    Page<KieuBuoc> findByTenKieuBuocContaining(String ten, Pageable pageable);
}
