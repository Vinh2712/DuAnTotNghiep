package com.example.sd_57_datn.Repository.Giay;

import com.example.sd_57_datn.Model.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu, UUID> {

    Page<ChatLieu> findByTenChatLieuContaining(String ten, Pageable pageable);

}