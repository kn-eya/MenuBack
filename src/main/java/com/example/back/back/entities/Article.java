package com.example.back.back.entities;
import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;


@Entity

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Articleid")
    public Long Articleid;
    public String title;
    public Double prix;
    public String description;
    @ManyToOne
    private Categorie categorie;

   @OneToMany(mappedBy = "article")
   private List<Lignedecommandes> lignedecommandes =new ArrayList<>();
   @OneToMany(mappedBy = "article")
   private List<ArticleLangue> articleLangues = new ArrayList<ArticleLangue>();

    public Article() {
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

    public Article(Long Articleid, String title, Double prix, String description) {
        this.Articleid = Articleid;
        this.title = title;
        this.prix = prix;
        this.description = description;
    }
}
