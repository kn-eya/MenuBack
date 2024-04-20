package com.example.back.back.entities;

import com.example.back.back.security.entities.AppUser;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
public class Admin extends AppUser {
    @OneToMany(mappedBy = "admin")
    private List<Market> marketList = new ArrayList<>();


    public List<Market> getMarketList() {
        return marketList;
    }

    public void setMarketList(List<Market> marketList) {
        this.marketList = marketList;
    }
}
