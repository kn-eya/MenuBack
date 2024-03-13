package com.example.back.back.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
@Entity
public class ArticleLangue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn( name ="Articleid")
    private Article article;
    @ManyToOne
    @JoinColumn( name="Langueid")
    private Langue langue;
}
