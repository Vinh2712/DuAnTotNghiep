package com.example.sd_57_datn.Service.GiayTheThao;

import com.example.sd_57_datn.Model.GiayTheThaoChiTiet;
import com.example.sd_57_datn.Repository.GiayTheThao.GiayTheThaoChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GiayTheThaoChiTietService {

    @Autowired
    private GiayTheThaoChiTietRepository repo;

    public List<GiayTheThaoChiTiet> getAll(){
        return repo.findAll();
    }

    public List<GiayTheThaoChiTiet> searchByName(String name){
        System.out.println("Name: "+name);
        return repo.findAllByNameProduct(name);
    }
}
