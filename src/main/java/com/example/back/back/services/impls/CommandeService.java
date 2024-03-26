package com.example.back.back.services.impls;

import com.example.back.back.entities.Commande;
import com.example.back.back.entities.Market;
import com.example.back.back.repositories.CommandeRepository;
import com.example.back.back.services.interfaces.ICommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CommandeService implements ICommande {
    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public List<Commande> getList() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getOne(Long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public Commande create(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteOne(Long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public Commande update(Commande commande) {

        return commandeRepository.save(commande);
    }


}
