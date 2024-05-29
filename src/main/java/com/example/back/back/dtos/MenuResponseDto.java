package com.example.back.back.dtos;


import java.util.ArrayList;
import java.util.List;

public class MenuResponseDto {
    private Long Marketid;

    public String libelle;
    public int phonenumber;
    public String addresse;
    public String email;



    public String logo;
    public String media;
   public  List<CategorieResponseDto> menu = new ArrayList<>();
    public MenuResponseDto() {
    }

    public MenuResponseDto(Long marketid, String libelle, int phonenumber, String addresse, String email, String logo, String media, List<CategorieResponseDto> menu) {
        Marketid = marketid;
        this.libelle = libelle;
        this.phonenumber = phonenumber;
        this.addresse = addresse;
        this.email = email;
        this.logo = logo;
        this.media = media;
        this.menu = menu;
    }

    public Long getMarketid() {
        return Marketid;
    }

    public void setMarketid(Long marketid) {
        Marketid = marketid;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public List<CategorieResponseDto> getMenu() {
        return menu;
    }

    public void setMenu(List<CategorieResponseDto> menu) {
        this.menu = menu;
    }
}
