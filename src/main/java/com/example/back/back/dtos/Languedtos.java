package com.example.back.back.dtos;

public class Languedtos {
    private Long Langueid;
    private String Libelle;

    public Languedtos() {
    }

    public Languedtos(Long langueid, String libelle) {
        Langueid = langueid;
        Libelle = libelle;
    }

    public Long getLangueid() {
        return Langueid;
    }

    public void setLangueid(Long langueid) {
        Langueid = langueid;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }
}
