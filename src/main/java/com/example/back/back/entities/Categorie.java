package com.example.back.back.entities;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity

public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Categorieid;
    private String libelle;
    private int niveau;
    @ManyToOne
    @JoinColumn(name = "sup_categorie_id")
    private Categorie supCategorie;
    @OneToMany(mappedBy = "supCategorie")
    private List<Categorie> sousCategorie;

    @OneToMany(mappedBy = "categorie")
    private List<Article> articleList = new ArrayList<Article>();
    @OneToMany(mappedBy = "categorielangue")
    private List<CategorieLangue> categorieLangues=new ArrayList<CategorieLangue>();

   @ManyToOne
    private Market market  ;
}
