package com.example.back.back.services.interfaces;



import com.example.back.back.entities.Evenement;

import java.util.List;

public interface IEvenement {
    public List<Evenement> getList() ;
    public Evenement  getOne (Long id) ;
    public  Evenement create(Evenement evenement) ;
    public  void deteletOne(long id);
    public  Evenement update (Evenement evenement);
}
