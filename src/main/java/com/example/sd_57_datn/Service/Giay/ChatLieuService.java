package com.example.sd_57_datn.Service.Giay;

import com.example.sd_57_datn.Model.ChatLieu;
import com.example.sd_57_datn.Repository.Giay.ChatLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ChatLieuService {
    @Autowired
    private ChatLieuRepository chatLieuRepository;



    public void add(ChatLieu chatLieu) {
        this.chatLieuRepository.save(chatLieu);
    }


    public void update(ChatLieu chatLieu, UUID id) {
        ChatLieu chatLieu1 = this.chatLieuRepository.findById(id).get();
        chatLieu1.setTenChatLieu(chatLieu.getTenChatLieu());
        chatLieu1.setGhiChu(chatLieu.getGhiChu());
        chatLieu1.setNgayTao(chatLieu.getNgayTao());
        chatLieu1.setNgaySua(chatLieu.getNgaySua());
        chatLieu1.setTrangThai(chatLieu.getTrangThai());
        this.chatLieuRepository.save(chatLieu1);
    }

//    @Override
//    public void delete(UUID id) {
//        DeGiay deGiay = repo.findById(id).get();
//        repo.delete(deGiay);
//    }

    public Page<ChatLieu> search(Pageable pageable, String name) {

        return this.chatLieuRepository.findByTenChatLieuContaining(name, pageable);
    }


    public Page<ChatLieu> pagination(Pageable pageable) {
        return this.chatLieuRepository.findAll(pageable);
    }


}
