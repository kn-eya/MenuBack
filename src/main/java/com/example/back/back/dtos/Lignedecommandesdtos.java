package com.example.back.back.dtos;

public class Lignedecommandesdtos {
    private Long Lignesdecommandesid;
    private int quantite;
    public Long Articleid;
    public Long Commandeid;

    public Lignedecommandesdtos() {
    }

    public Lignedecommandesdtos(Long lignesdecommandesid, int quantite, Long articleid, Long commandeid) {
        Lignesdecommandesid = lignesdecommandesid;
        this.quantite = quantite;
        Articleid = articleid;
        Commandeid = commandeid;
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

    public Long getArticleid() {
        return Articleid;
    }

    public void setArticleid(Long articleid) {
        Articleid = articleid;
    }

    public Long getCommandeid() {
        return Commandeid;
    }

    public void setCommandeid(Long commandeid) {
        Commandeid = commandeid;
    }
}
