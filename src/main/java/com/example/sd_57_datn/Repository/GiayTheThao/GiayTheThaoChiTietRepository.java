package com.example.sd_57_datn.Repository.GiayTheThao;

import com.example.sd_57_datn.Model.*;
import com.example.sd_57_datn.Model.GiayTheThaoChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GiayTheThaoChiTietRepository extends JpaRepository<GiayTheThaoChiTiet, UUID> {

    @Query("select giayTheThaoChiTiet from GiayTheThaoChiTiet giayTheThaoChiTiet where giayTheThaoChiTiet.giayTheThao.id=?1")
    List<GiayTheThaoChiTiet> getAllById(UUID id);

    List<GiayTheThaoChiTiet> findByGiayTheThao(GiayTheThao giayTheThao);

    List<GiayTheThaoChiTiet> findByGiayTheThaoAndMauSacAndSize(GiayTheThao giayTheThao, MauSac mauSac, Size size);

    //tìm size số lượng màu sắc
    @Query("select p from GiayTheThaoChiTiet p where p.giayTheThao.id = ?1 and p.mauSac.id = ?2 and p.size.id = ?3")
    GiayTheThaoChiTiet findIdByIdGiayTheThaoMauSacSize(UUID id, UUID idMauSac, UUID idSize);

    @Query("SELECT SUM(sp.soLuong) FROM GiayTheThaoChiTiet sp")
    Integer sumSoLuong();
    @Query("SELECT gttct FROM GiayTheThaoChiTiet gttct JOIN gttct.giayTheThao gtt WHERE gtt.tenGiayTheThao =:ten ")
    List<GiayTheThaoChiTiet> findAllByNameProduct(@Param("ten") String name);
}
