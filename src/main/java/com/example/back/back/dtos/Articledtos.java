package com.example.back.back.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import org.apache.juli.logging.Log;


public class Articledtos {

    public Long Articleid;

    public String title;

    public Double prix;

    public String description;

    public Long   categorieId ;


    public Articledtos() {
    }

    public Articledtos(Long articleid, String title, Double prix, String description, Long categorieId) {
        Articleid = articleid;
        this.title = title;
        this.prix = prix;
        this.description = description;
        this.categorieId = categorieId;
    }

    public Long getArticleid() {
        return Articleid;
    }

    public void setArticleid(Long articleid) {
        Articleid = articleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }
}
