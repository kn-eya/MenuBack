package com.example.back.back.services.impls;

import com.example.back.back.entities.ArticleLangue;
import com.example.back.back.entities.Feedback;
import com.example.back.back.repositories.ArticleLangueRepository;
import com.example.back.back.services.interfaces.IArticleLangue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ArticleLangueService implements IArticleLangue {


    @Autowired
    private ArticleLangueRepository articleLangueRepository;

    @Override
    public List<ArticleLangue> getList() {
        return articleLangueRepository.findAll();
    }
    @Override

    public ArticleLangue getOne(Long id) {
        return articleLangueRepository.findById(id).get();
    }

    @Override
    public ArticleLangue create(ArticleLangue articleLangue) {
        return articleLangueRepository.save(articleLangue);
    }

    @Override
    public void deteletOne(long id) {
        articleLangueRepository.deleteById(id);
    }

    @Override
    public ArticleLangue update(ArticleLangue articleLangue) {

        return articleLangueRepository.save(articleLangue);
    }
}
