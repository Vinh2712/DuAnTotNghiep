package com.example.sd_57_datn.Repository.Giay;

import com.example.sd_57_datn.Model.DinhTanGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DinhTanGiayRepository extends JpaRepository<DinhTanGiay, UUID> {

    List<DinhTanGiay> findByTenDinhTanGiayContainingOrderById(String tenDinhTanGiay);

}
