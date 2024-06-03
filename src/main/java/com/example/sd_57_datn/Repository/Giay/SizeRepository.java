package com.example.sd_57_datn.Repository.Giay;

import com.example.sd_57_datn.Model.GiayTheThao;
import com.example.sd_57_datn.Model.Size;
import com.example.sd_57_datn.Model.ThuongHieu;
import com.example.sd_57_datn.Model.TrongLuong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SizeRepository extends JpaRepository<Size, UUID> {

    Page<Size> findBySizeContainingOrderById(String ten, Pageable pageable);

}