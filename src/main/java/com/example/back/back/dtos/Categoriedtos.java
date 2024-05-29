package com.example.back.back.dtos;


import org.apache.juli.logging.Log;

public class Categoriedtos {
    private Long Categorieid;
     private String SupcategorieLibelle;

    public String getSupcategorieLibelle() {
        return SupcategorieLibelle;
    }

    public void setSupcategorieLibelle(String supcategorieLibelle) {
        SupcategorieLibelle = supcategorieLibelle;
    }

    public Long getCategorieid() {
        return Categorieid;
    }

    public void setCategorieid(Long categorieid) {
        Categorieid = categorieid;
    }

    private String libelle;
    private int niveau;
    private Long supCategorieId;
    public Long Marketid;
    private boolean notHasSubCategories;

    public Categoriedtos() {
    }

    public Categoriedtos(Long categorieid, String libelle, int niveau, Long supCategorieId, Long marketid) {
        Categorieid = categorieid;
        this.libelle = libelle;
        this.niveau = niveau;
        this.supCategorieId = supCategorieId;
        this.Marketid = marketid;
    }

    public boolean isNotHasSubCategories() {
        return notHasSubCategories;
    }

    public void setNotHasSubCategories(boolean notHasSubCategories) {
        this.notHasSubCategories = notHasSubCategories;
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

    public Long getSupCategorieId() {
        return supCategorieId;
    }

    public void setSupCategorieId(Long supCategorieId) {
        this.supCategorieId = supCategorieId;
    }

    public Long getMarketid() {
        return Marketid;
    }

    public void setMarketid(Long marketid) {
        Marketid = marketid;
    }
}
