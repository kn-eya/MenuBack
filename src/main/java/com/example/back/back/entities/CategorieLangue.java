package com.example.back.back.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
public class CategorieLangue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn( name ="Categorieid")
    private Categorie categorielangue;
    @ManyToOne
    @JoinColumn( name="Langueid")
    private Langue languecategorie;
}
