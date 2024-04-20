package com.example.back.back.api;

import com.example.back.back.dtos.Articledtos;
import com.example.back.back.entities.Article;
import com.example.back.back.entities.Categorie;
import com.example.back.back.repositories.ArticleRepository;
import com.example.back.back.services.impls.ArticleService;
import com.example.back.back.services.impls.CategorieService;
import com.example.back.back.services.interfaces.IArticle;
import com.example.back.back.services.interfaces.ICategorie;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/article")
public class ArticleController {
    @Autowired
    public IArticle  iArticle ;
    @Autowired
    public ICategorie iCategorie;


    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    private ArticleRepository articleRepository;

  @PostMapping("add")
    public ResponseEntity<Articledtos> createArticle(@RequestBody Articledtos articledtos ){
        Article article = modelMapper.map(articledtos,Article.class);
        article.setCategorie(iCategorie.getOne(articledtos.categorieId));
        Article saved = iArticle.create(article);
        return new ResponseEntity<>( modelMapper.map(saved, Articledtos.class), HttpStatus.CREATED);
    }



    @GetMapping("/getById/{id}")
    public ResponseEntity<Articledtos> findArticleById(@PathVariable Long id){


        Article  article= iArticle.getOne(id);

        return  new ResponseEntity<>( modelMapper.map(article,Articledtos.class), HttpStatus.OK);

    }

    @GetMapping("getAllbyCategorie/{idCategorie}")
    public ResponseEntity<List<Articledtos>> getAllByCategorie(@PathVariable Long idCategorie) {
        return  ResponseEntity.ok(( iArticle.getList()
                .stream().filter(a->a.getCategorie().getCategorieid()==idCategorie).map(al->modelMapper.map(al,Articledtos.class))
                .collect(Collectors.toList())));
    }





}
