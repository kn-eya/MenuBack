package com.example.back.back.services.interfaces;

import com.example.back.back.entities.Article;
import com.example.back.back.entities.Lignedecommandes;
import com.example.back.back.entities.Market;

import java.util.List;

public interface ILignedecommandes {
    public List<Lignedecommandes> getList() ;
    public Lignedecommandes  getOne (Long id) ;
    public  Lignedecommandes  create(Lignedecommandes lignedecommandes) ;
    public  void deleteOne(long id);
    public  Lignedecommandes update (Lignedecommandes lignedecommandes);


}
