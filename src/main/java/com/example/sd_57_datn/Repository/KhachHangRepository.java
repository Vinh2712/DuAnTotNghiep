package com.example.sd_57_datn.Repository;

import com.example.sd_57_datn.Model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
  // Định nghĩa thêm các phương thức tùy chỉnh nếu cần
}