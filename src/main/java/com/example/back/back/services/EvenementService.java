package com.example.back.back.services;

import com.example.back.back.entities.Evenement;
import com.example.back.back.repositories.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvenementService {
    @Autowired
    private EvenementRepository evenementRepository;
    public Evenement createEvenement (Evenement evenement){
        Evenement createdEvenement=new Evenement();
         return  evenementRepository.save(createdEvenement);
        

    }
}
