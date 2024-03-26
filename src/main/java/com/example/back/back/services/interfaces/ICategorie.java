package com.example.back.back.services.interfaces;

import com.example.back.back.entities.Article;
import com.example.back.back.entities.Categorie;

import java.util.List;

public interface ICategorie {
    public List<Categorie> getList() ;
    public Categorie  getOne (Long id) ;
    public  Categorie  create(Categorie categorie) ;
    public  void deleteOne(Long id);
    public  Categorie update (Categorie categorie);

}
