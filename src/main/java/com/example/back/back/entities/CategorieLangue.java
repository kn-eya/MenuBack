package com.example.back.back.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class CategorieLangue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategorieLangueid;
    public  String Traduction;
    @ManyToOne
    @JoinColumn( name ="Categorieid")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn( name="Langueid")
    private Langue langue;

    public CategorieLangue() {
    }

    public Long getCategorieLangueid() {
        return CategorieLangueid;
    }

    public void setCategorieLangueid(Long categorieLangueid) {
        CategorieLangueid = categorieLangueid;
    }

    public String getTraduction() {
        return Traduction;
    }

    public void setTraduction(String traduction) {
        Traduction = traduction;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }
}
