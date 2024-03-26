package com.example.back.back.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
@Entity
public class ArticleLangue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ArticleLangueid;
    public  String Traduction;

    @ManyToOne
    @JoinColumn( name ="Articleid")
    private Article article;
    @ManyToOne
    @JoinColumn( name="Langueid")
    private Langue langue;

    public ArticleLangue() {
    }

    public ArticleLangue(Long articleLangueid, String traduction, Article article, Langue langue) {
        ArticleLangueid = articleLangueid;
        Traduction = traduction;
        this.article = article;
        this.langue = langue;
    }

    public Long getArticleLangueid() {
        return ArticleLangueid;
    }

    public void setArticleLangueid(Long articleLangueid) {
        ArticleLangueid = articleLangueid;
    }

    public String getTraduction() {
        return Traduction;
    }

    public void setTraduction(String traduction) {
        Traduction = traduction;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }
}
