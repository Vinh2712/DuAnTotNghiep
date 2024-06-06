package com.example.sd_57_datn.Repository.Giay;

import com.example.sd_57_datn.Model.DayGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DayGiayRepository extends JpaRepository<DayGiay, UUID> {

    List<DayGiay> findByTenDayGiayContainingOrderById(String tenDayGiay);

}
