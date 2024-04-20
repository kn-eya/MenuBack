package com.example.back.back.entities;


import javax.persistence.*;

@Entity

public class Lignedecommandes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Lignesdecommandesid;
    private int quantite;
    @ManyToOne
    @JoinColumn( name = "Articleid")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "Commandeid")
    private Commande commande;
    private Double TotalPrix;

    public Lignedecommandes() {
    }

    public Lignedecommandes(Long lignesdecommandesid, int quantite, Article article, Commande commande) {
        Lignesdecommandesid = lignesdecommandesid;
        this.quantite = quantite;
        this.article = article;
        this.commande = commande;
    }

    public Long getLignesdecommandesid() {
        return Lignesdecommandesid;
    }

    public void setLignesdecommandesid(Long lignesdecommandesid) {
        Lignesdecommandesid = lignesdecommandesid;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public void setTotalPrix(int quantite,double prix) {
        TotalPrix = quantite*prix;
    }
}
