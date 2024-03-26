package com.example.back.back.services.impls;

import com.example.back.back.entities.Evenement;
import com.example.back.back.repositories.EvenementRepository;
import com.example.back.back.services.interfaces.IEvenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EvenementService implements IEvenement {
    @Autowired
    private EvenementRepository evenementRepository;
    @Override
    public List<Evenement> getList() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement getOne(Long id) {
        return evenementRepository.findById(id).get();
    }

    @Override
    public Evenement create(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public void deleteOne(Long id) {
        evenementRepository.deleteById(id);
    }

    @Override
    public Evenement update(Evenement evenement) {

        return evenementRepository.save(evenement);
    }


}
