package com.example.sd_57_datn.Repository.Giay;

import com.example.sd_57_datn.Model.DeGiay;
import com.example.sd_57_datn.Model.TrongLuong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrongLuongRepository extends JpaRepository<TrongLuong, UUID> {

    Page<TrongLuong> findByTenTrongLuongContainingOrderById(String ten, Pageable pageable);

}
