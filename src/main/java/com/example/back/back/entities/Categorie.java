package com.example.back.back.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Categorieid;
    private String libelle;
    private int niveau;

    @ManyToOne
    @JoinColumn(name = "sup_categorie_id")
    private Categorie supCategorie;
   @JsonIgnore
  //  @LazyCollection(LazyCollectionOption.FALSE)

    @OneToMany(mappedBy = "supCategorie",fetch = FetchType.LAZY)
    private List<Categorie> sousCategorie;

    @OneToMany(mappedBy = "categorie")
    private List<Article> articleList = new ArrayList<Article>();

    @OneToMany(mappedBy = "categorie")
    private List<CategorieLangue> categorieLangues=new ArrayList<CategorieLangue>();
    @JsonIgnore
    //@LazyCollection(LazyCollectionOption.FALSE)
   @ManyToOne
    private Market market  ;

    public Categorie() {
    }

    public Categorie(Long categorieid, String libelle, int niveau, Categorie supCategorie, List<Categorie> sousCategorie, List<Article> articleList, List<CategorieLangue> categorieLangues, Market market) {
        Categorieid = categorieid;
        this.libelle = libelle;
        this.niveau = niveau;
        this.supCategorie = supCategorie;
        this.sousCategorie = sousCategorie;
        this.articleList = articleList;
        this.categorieLangues = categorieLangues;
        this.market = market;
    }

    public void setCategorieid(Long categorieid) {
        Categorieid = categorieid;
    }

    public Long getCategorieid() {
        return Categorieid;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Categorie getSupCategorie() {
        return supCategorie;
    }

    public void setSupCategorie(Categorie supCategorie) {
        this.supCategorie = supCategorie;
    }

    public List<Categorie> getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(List<Categorie> sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<CategorieLangue> getCategorieLangues() {
        return categorieLangues;
    }

    public void setCategorieLangues(List<CategorieLangue> categorieLangues) {
        this.categorieLangues = categorieLangues;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}
