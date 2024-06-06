package com.example.sd_57_datn.Repository.GiayTheThao;

import com.example.sd_57_datn.Model.GiayTheThao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GiayTheThaoRepository extends JpaRepository<GiayTheThao, UUID> {

    @Query("select giayTheThao from  GiayTheThao  giayTheThao where  giayTheThao.id = ?1")
    GiayTheThao getGiayTheThaoById(UUID id);

    Page<GiayTheThao> findByTrangThai (int trangThai, Pageable pageable);

    List<GiayTheThao> findByTenGiayTheThao(String tenGiayTheThao);

}
