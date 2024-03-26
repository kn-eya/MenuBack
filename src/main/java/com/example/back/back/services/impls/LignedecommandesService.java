package com.example.back.back.services.impls;

import com.example.back.back.entities.Article;
import com.example.back.back.entities.Lignedecommandes;
import com.example.back.back.entities.MarketLangue;
import com.example.back.back.repositories.LignedecommandesRepository;
import com.example.back.back.services.interfaces.ILignedecommandes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LignedecommandesService implements ILignedecommandes {
    @Autowired
    private LignedecommandesRepository lignedecommandesRepository;

    @Override
    public List<Lignedecommandes> getList() {
        return lignedecommandesRepository.findAll();
    }
    @Override
    public Lignedecommandes getOne(Long id) {
        return lignedecommandesRepository.findById(id).get();
    }



    @Override
    public Lignedecommandes create(Lignedecommandes lignedecommandes) {
        return  lignedecommandesRepository.save(lignedecommandes);
    }
    @Override
    public void deleteOne(Long id) {
        lignedecommandesRepository.deleteById(id);
    }

    @Override
    public Lignedecommandes update(Lignedecommandes lignedecommandes) {

        return lignedecommandesRepository.save(lignedecommandes);
    }




}
