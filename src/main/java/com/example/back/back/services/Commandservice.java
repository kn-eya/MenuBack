package com.example.back.back.services;

import com.example.back.back.entities.Commande;
import com.example.back.back.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Commandservice {
    @Autowired
    private CommandeRepository commandeRepository;
    public List<Commande> getAllCommandes(){
        return commandeRepository.findAll();
    }
    public Commande createCommande(String reference, int tablenumb, String name, String statuscommand) {

        Commande commande = new Commande();
        commande.setReference(reference);
        commande.setTablenumb(tablenumb);
        commande.setName(name);
        commande.setStatuscommand(statuscommand);
        return commandeRepository.save(commande);


    }
}
