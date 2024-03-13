package com.example.back.back.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    public String libelle;
    public int phonenumber;
    public String addresse;
    @Column(unique = true)
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




public Market() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
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

    public Market(Integer id, String libelle, Integer phonenumber, String addresse, String email, String logo, String media) {
        this.id = id;
        this.libelle = libelle;
        this.phonenumber = phonenumber;
        this.addresse = addresse;
        this.email = email;
        this.logo = logo;
        this.media = media;
    }

}
