package com.example.back.back.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Libelle;
    @OneToMany(mappedBy = "langue")
    private List<MarketLangue> marketLangues =new ArrayList<MarketLangue>();
@OneToMany(mappedBy = "langue")
private List<ArticleLangue> articleLangues = new ArrayList<ArticleLangue>();
@OneToMany(mappedBy = "languecategorie")
private List<CategorieLangue> categorieLangues=new ArrayList<CategorieLangue>();


    public Langue() {
    }

    public Langue(Long id, String libelle) {
        this.id = id;
        Libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }
}
