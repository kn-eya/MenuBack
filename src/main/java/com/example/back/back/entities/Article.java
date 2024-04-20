package com.example.back.back.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity


public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Articleid")
    public Long Articleid;
    public String title;
    public Double prix;
    public String description;



    public Long   categorieId ;
   @JsonIgnore
   //@LazyCollection(LazyCollectionOption.FALSE)
    @ManyToOne
    public Categorie categorie;
    @JsonIgnore
   // @LazyCollection(LazyCollectionOption.FALSE)
   @OneToMany(mappedBy = "article",fetch = FetchType.LAZY)
   private List<Lignedecommandes> lignedecommandes =new ArrayList<>();
    @JsonIgnore
   // @LazyCollection(LazyCollectionOption.FALSE)
   @OneToMany(mappedBy = "article",fetch = FetchType.LAZY)
   private List<ArticleLangue> articleLangues = new ArrayList<ArticleLangue>();

    public Article() {
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }
    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

    public Long getArticleid() {
        return Articleid;
    }

    public void setArticleid(Long articleid) {
        Articleid = articleid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Article(Long Articleid, String title, Double prix, String description,   Long   categorieId ) {
        this.Articleid = Articleid;
        this.title = title;
        this.prix = prix;
        this.description = description;
        this.categorieId = categorieId;
 ;   }
}
