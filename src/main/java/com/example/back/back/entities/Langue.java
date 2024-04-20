package com.example.back.back.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Langueid;
    private String Libelle;
    @OneToMany(mappedBy = "langue")
    private List<MarketLangue> marketLangues =new ArrayList<MarketLangue>();
    @OneToMany(mappedBy = "langue")
    private List<ArticleLangue> articleLangues = new ArrayList<ArticleLangue>();
    @OneToMany(mappedBy = "langue")
    private List<CategorieLangue> categorieLangues=new ArrayList<CategorieLangue>();


    public Langue() {
    }

    public Langue(Long Langueid, String libelle) {
        this.Langueid = Langueid;
        Libelle = libelle;
    }

    public Long getId() {
        return Langueid;
    }

    public void setId(Long Langueid) {
        this.Langueid = Langueid;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }
}
