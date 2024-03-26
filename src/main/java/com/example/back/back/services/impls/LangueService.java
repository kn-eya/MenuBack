package com.example.back.back.services.impls;

import com.example.back.back.entities.Commande;
import com.example.back.back.entities.Langue;
import com.example.back.back.repositories.LangueRepository;
import com.example.back.back.services.interfaces.ILangue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangueService implements ILangue{

    @Autowired
    private LangueRepository  langueRepository;
    @Override
    public List<Langue> getList() {
        return langueRepository.findAll();
    }

    @Override
    public Langue getOne(Long id) {
        return langueRepository.findById(id).get();
    }

    @Override
    public Langue create(Langue langue) {
        return langueRepository.save(langue);
    }

    @Override
    public void deteletOne(long id) {
        langueRepository.deleteById(id);
    }

    @Override
    public Langue update(Langue langue) {

        return langueRepository.save(langue);
    }

}
