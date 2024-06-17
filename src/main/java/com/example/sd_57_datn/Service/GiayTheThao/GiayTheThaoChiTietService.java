package com.example.sd_57_datn.Service.GiayTheThao;

import com.example.sd_57_datn.Model.GiayTheThaoChiTiet;
import com.example.sd_57_datn.Repository.GiayTheThao.GiayTheThaoChiTietRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GiayTheThaoChiTietService implements GiayTheThaoChiTietImpl{

    @Autowired
    private GiayTheThaoChiTietRepository repo;

    public List<GiayTheThaoChiTiet> getAll(){
        return repo.findAll();
    }

    public List<GiayTheThaoChiTiet> searchByName(String name){
        System.out.println("Name: "+name);
        return repo.findAllByNameProduct(name);
    }
    public GiayTheThaoChiTiet getById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public GiayTheThaoChiTiet save(GiayTheThaoChiTiet giayTheThaoChiTiet) {
        return repo.save(giayTheThaoChiTiet);
    }

    @Override
    public GiayTheThaoChiTiet findIdByIdGiayTheThao(UUID id, UUID idMauSac, UUID idSize) {
        return null;
    }
}
