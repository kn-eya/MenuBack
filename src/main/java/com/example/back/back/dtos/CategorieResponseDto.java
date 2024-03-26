package com.example.back.back.dtos;

import com.example.back.back.entities.Article;

import java.util.ArrayList;
import java.util.List;

public class CategorieResponseDto {
    private Long id ;
    private String libelle;
    private int niveau;
    List<CategorieResponseDto> sousCategorie= new ArrayList<>() ;
    List<Article> articles = new ArrayList<>();

    public CategorieResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<CategorieResponseDto> getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(List<CategorieResponseDto> sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
