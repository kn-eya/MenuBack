package com.example.back.back.controllers;
import org.springframework.http.ResponseEntity;
import com.example.back.back.entities.Article;
import com.example.back.back.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/articles")
public class ArticleController {
@Autowired
    private ArticleService articleService;
     @GetMapping("article")
     public ResponseEntity<List<Article>> getAllArticles(){
         List<Article> articles = articleService.getAllArticles();
         return ResponseEntity.ok(articles);
     }
      @PostMapping("/add/article")
      public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article createdArticle = articleService.createArticle(article.getTitle(), article.getPrix(), article.getDescription());
        return ResponseEntity.ok(createdArticle);}

    }




