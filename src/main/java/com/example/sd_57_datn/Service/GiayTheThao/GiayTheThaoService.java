package com.example.sd_57_datn.Service.GiayTheThao;

import com.example.sd_57_datn.Model.GiayTheThao;
import com.example.sd_57_datn.Repository.GiayTheThao.GiayTheThaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class GiayTheThaoService implements GiayTheThaoImpl {
    @Autowired
    private GiayTheThaoRepository repo;

    public List<GiayTheThao> findGiayTheThao(String tenGiayTheThao) {
        if (tenGiayTheThao != null) {
            return repo.findByTenGiayTheThao(tenGiayTheThao);
        } else {
            return repo.findAll();
        }

    }

    @Override
    public List<GiayTheThao> getALl() {
        return null;
    }

    @Override
    public List<GiayTheThao> getAllWithoutInCTGGCTSP(UUID id) {
        return null;
    }

    @Override
    public GiayTheThao getOne(UUID id) {
        return null;
    }

}
