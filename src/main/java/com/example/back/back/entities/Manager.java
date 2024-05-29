package com.example.back.back.entities;

import com.example.back.back.security.entities.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
@DiscriminatorValue("3")
public class Manager extends AppUser {
    @ManyToMany
    @JoinTable(
            name = "manager_market",
            joinColumns = @JoinColumn(name = "manager_id"),
            inverseJoinColumns = @JoinColumn(name = "Marketid")
    )
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Market> marketList ;
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    private Admin  admin ;

    public Manager() {
    }

    public List<Market> getMarketList() {
        return marketList;
    }

    public void setMarketList(List<Market> marketList) {
        this.marketList = marketList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
