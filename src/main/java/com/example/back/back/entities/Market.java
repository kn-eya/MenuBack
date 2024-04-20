package com.example.back.back.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.catalina.Manager;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Marketid;

    public String libelle;
    public int phonenumber;
    public String addresse;
    public String email;
    public String logo;
    public String media;

    @OneToMany(mappedBy = "market")
    private List<Categorie> categorieList = new ArrayList<Categorie>();

    @OneToMany(mappedBy = "market")
    private List<MarketLangue> marketLangues =new ArrayList<MarketLangue>();

   @OneToMany(mappedBy = "marketcommande")
   private List<Commande>commandes=new ArrayList<>();

   @OneToMany(mappedBy = "marketfeedback")
   private List<Feedback> feedbacks=new ArrayList<Feedback>();

   @OneToMany(mappedBy = "marketevenement")
   private List<Evenement> evenements= new ArrayList<Evenement>();
   @ManyToOne
   private  Admin admin ;



    public Market() {
    }

    public Long getMarketid() {
        return Marketid;
    }



    public void setMarketid(Long marketid) {
        Marketid = marketid;
    }



    public Market(Long Marketid, String libelle, int phonenumber, String addresse, String email, String logo, String media) {
        this.Marketid = Marketid;
        this.libelle = libelle;
        this.phonenumber = phonenumber;
        this.addresse = addresse;
        this.email = email;
        this.logo = logo;
        this.media = media;

    }

    public Long getId() {
        return Marketid;
    }

    public void setId(Long Marketid) {
        this.Marketid = Marketid;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }

    public List<MarketLangue> getMarketLangues() {
        return marketLangues;
    }

    public void setMarketLangues(List<MarketLangue> marketLangues) {
        this.marketLangues = marketLangues;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
}
