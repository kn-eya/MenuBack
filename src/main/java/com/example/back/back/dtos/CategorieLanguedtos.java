package com.example.back.back.dtos;

public class CategorieLanguedtos {
    private Long CategorieLangueid;
    public Long Categorieid;
    public Long Langueid;
    public String Traduction;

    public String getTraduction() {
        return Traduction;
    }

    public void setTraduction(String traduction) {
        Traduction = traduction;
    }


    public CategorieLanguedtos() {
    }

    public CategorieLanguedtos(Long categorieLangueid, Long categorieid, Long langueid,String traduction) {
        CategorieLangueid = categorieLangueid;
        Categorieid = categorieid;
        Langueid = langueid;
        Traduction=traduction;
    }

    public Long getCategorieLangueid() {
        return CategorieLangueid;
    }

    public void setCategorieLangueid(Long categorieLangueid) {
        CategorieLangueid = categorieLangueid;
    }

    public Long getCategorieid() {
        return Categorieid;
    }

    public void setCategorieid(Long categorieid) {
        Categorieid = categorieid;
    }

    public Long getLangueid() {
        return Langueid;
    }

    public void setLangueid(Long langueid) {
        Langueid = langueid;
    }
}
