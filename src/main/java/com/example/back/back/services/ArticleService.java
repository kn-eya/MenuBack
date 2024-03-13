package com.example.back.back.services;

import com.example.back.back.entities.Article;
import com.example.back.back.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleService  {

@Autowired
private ArticleRepository articleRepository;
  public List<Article> getAllArticles(){
    return articleRepository.findAll();
}
  public Article createArticle(String title,Double prix,String description) {
        Article article = new Article();
        article.setTitle(title);
        article.setPrix(prix);
        article.setDescription(description);
        return  articleRepository.save(article);

    }



    }



