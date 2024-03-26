package com.example.back.back.services.impls;

import com.example.back.back.entities.Categorie;
import com.example.back.back.repositories.CategorieRepository;
import com.example.back.back.services.interfaces.ICategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService implements ICategorie {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<Categorie> getList() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie getOne(Long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public Categorie create(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteOne(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie update(Categorie categorie) {

        return categorieRepository.save(categorie);
    }
}
