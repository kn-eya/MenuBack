package com.example.back.back.entities;

import com.example.back.back.security.entities.AppUser;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("3")
public class Manager extends AppUser {
    @ManyToOne
    private Market market ;

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}
