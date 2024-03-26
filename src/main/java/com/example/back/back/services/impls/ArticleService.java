package com.example.back.back.services.impls;

import com.example.back.back.entities.Article;
import com.example.back.back.repositories.ArticleRepository;
import com.example.back.back.services.interfaces.IArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticle {

    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<Article> getList() {
        return articleRepository.findAll();
    }
    @Override
    public Article getOne(Long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteOne(long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article update(Article article) {

        return articleRepository.save(article);
    }



}
