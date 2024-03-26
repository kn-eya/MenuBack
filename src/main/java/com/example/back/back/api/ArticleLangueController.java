package com.example.back.back.api;

import com.example.back.back.dtos.ArticleLanguedtos;
import com.example.back.back.dtos.Articledtos;
import com.example.back.back.dtos.Marketdtos;
import com.example.back.back.entities.Article;
import com.example.back.back.entities.ArticleLangue;
import com.example.back.back.services.interfaces.IArticle;
import com.example.back.back.services.interfaces.IArticleLangue;
import com.example.back.back.services.interfaces.ILangue;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("al")

public class ArticleLangueController {
    @Autowired
    public IArticle iArticle;
    @Autowired
    public ILangue ilangue;
    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    IArticleLangue iArticleLangue;


    @PostMapping("/add")

    public ResponseEntity<ArticleLanguedtos> createArticleLangue(@RequestBody ArticleLanguedtos articleLanguedtos){
      ArticleLangue articleLangue= modelMapper.map(articleLanguedtos,ArticleLangue.class);
      articleLangue.setLangue(ilangue.getOne(articleLanguedtos.Langueid));
      articleLangue.setArticle(iArticle.getOne(articleLanguedtos.Articleid));
        ArticleLangue created =iArticleLangue.create(articleLangue);
        return new ResponseEntity<>( modelMapper.map(created, ArticleLanguedtos.class), HttpStatus.CREATED);

    }
}
