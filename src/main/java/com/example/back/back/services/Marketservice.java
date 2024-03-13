package com.example.back.back.services;

import com.example.back.back.entities.Market;
import com.example.back.back.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Marketservice {
    @Autowired
    private MarketRepository marketRepository;

    public Market createMarket(String libelle,int phonenumber,String addresse,String email,String logo,String media){
        Market market = new Market();
        market.setLibelle(libelle);
        market.setPhonenumber(phonenumber);
        market.setEmail(email);
        market.setLogo(logo);
        market.setMedia(media);
        return marketRepository.save(market);
    }
}
