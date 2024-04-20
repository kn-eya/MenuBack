package com.example.back.back.entities;
import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Commandeid")
    private Long Commandeid;
    private String reference;
    private int tablenumb;
    private String name;
    private String statuscommand;







    public List<Lignedecommandes> getLignedecommandes() {
        return lignedecommandes;
    }

    public void setLignedecommandes(List<Lignedecommandes> lignedecommandes) {
        this.lignedecommandes = lignedecommandes;
    }

    public Market getMarketcommande() {
        return marketcommande;
    }

    public void setMarketcommande(Market marketcommande) {
        this.marketcommande = marketcommande;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @OneToMany(mappedBy = "commande")
     private List<Lignedecommandes> lignedecommandes =new ArrayList<Lignedecommandes>();
    @ManyToOne
    private Market marketcommande;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Feedbackid")
    private Feedback feedback;



   public Long getCommandeid() {
        return Commandeid;
    }

    public void setCommandeid(Long commandeid) {
        Commandeid = commandeid;
    }

    public int getTablenumb() {
        return tablenumb;
    }



    public Commande() {
    }



    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }



    public void setTablenumb(int tablenumb) {
        this.tablenumb = tablenumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatuscommand() {
        return statuscommand;
    }

    public void setStatuscommand(String statuscommand) {
        this.statuscommand = statuscommand;
    }

    public Commande(Long Commandeid, String reference, int tablenumb, String name, String statuscommand) {
        this.Commandeid = Commandeid;
        this.reference = reference;
        this.tablenumb = tablenumb;
        this.name = name;
        this.statuscommand = statuscommand;

    }

}
