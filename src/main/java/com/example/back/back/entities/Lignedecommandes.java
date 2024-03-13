package com.example.back.back.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Lignedecommandes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    @ManyToOne
    @JoinColumn( name = "Articleid")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "Commandeid")
    private Commande commande;


}
