package com.example.back.back.services.interfaces;

import com.example.back.back.entities.Categorie;
import com.example.back.back.entities.Commande;

import java.util.List;

public interface ICommande {
    public List<Commande> getList() ;
    public Commande  getOne (Long id) ;
    public  Commande  create(Commande commande) ;
    public  void deleteOne(Long id);
    public  Commande update (Commande commande);
}
