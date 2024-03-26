package com.example.back.back.services.interfaces;

import com.example.back.back.entities.ArticleLangue;
import com.example.back.back.entities.Feedback;

import java.util.List;

public interface IArticleLangue {
    List<ArticleLangue> getList();

    ArticleLangue getOne(Long id);

    ArticleLangue create(ArticleLangue articleLangue);

    void deteletOne(long id);

    ArticleLangue update(ArticleLangue articleLangue);
}
