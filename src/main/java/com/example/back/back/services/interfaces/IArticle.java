package com.example.back.back.services.interfaces;

import com.example.back.back.dtos.Articledtos;
import com.example.back.back.entities.Article;
import com.example.back.back.entities.Market;

import java.util.List;

public interface IArticle {

    public List<Article> getList() ;
    public Article getOne (Long id) ;
    public  Article  create(Article article) ;
    public  void deleteOne(Long id);
    public  Article update (Article article);



}
