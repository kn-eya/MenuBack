package com.example.back.back.services.interfaces;

import com.example.back.back.entities.Evenement;
import com.example.back.back.entities.Langue;

import java.util.List;

public interface ILangue {
    public List<Langue> getList() ;
    public Langue getOne (Long id) ;
    public Langue create(Langue langue) ;
    public  void deteletOne(long id);
    public  Langue update (Langue langue);
}
