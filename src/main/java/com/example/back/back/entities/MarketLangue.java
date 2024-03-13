package com.example.back.back.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.*;
@Entity
public class MarketLangue
{@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn  ( name ="Marketid")
    private Market market;
    @ManyToOne
    @JoinColumn( name="Langueid")
    private Langue langue;

}
