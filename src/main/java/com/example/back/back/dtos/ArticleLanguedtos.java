package com.example.back.back.dtos;

public class ArticleLanguedtos {
    private int id;
    public Long Articleid;
    public Long Langueid;
    public String Traduction;

    public ArticleLanguedtos() {
    }

    public ArticleLanguedtos(int id, Long articleid, Long langueid, String traduction) {
        this.id = id;
        Articleid = articleid;
        Langueid = langueid;
        Traduction = traduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getArticleid() {
        return Articleid;
    }

    public void setArticleid(Long articleid) {
        Articleid = articleid;
    }

    public Long getLangueid() {
        return Langueid;
    }

    public void setLangueid(Long langueid) {
        Langueid = langueid;
    }

    public String getTraduction() {
        return Traduction;
    }

    public void setTraduction(String traduction) {
        Traduction = traduction;
    }
}
