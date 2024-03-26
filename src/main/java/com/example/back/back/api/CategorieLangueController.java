package com.example.back.back.api;

import com.example.back.back.dtos.ArticleLanguedtos;
import com.example.back.back.dtos.CategorieLanguedtos;
import com.example.back.back.dtos.Commandedtos;
import com.example.back.back.entities.ArticleLangue;
import com.example.back.back.entities.CategorieLangue;
import com.example.back.back.services.interfaces.ICategorie;
import com.example.back.back.services.interfaces.ICategorieLangue;
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
@RequestMapping("cl")

public class CategorieLangueController {
    @Autowired
    public ICategorie iCategorie;
    @Autowired
    public ILangue iLangue;
    @Autowired
    public ICategorieLangue iCategorieLangue;
    @Autowired
    private ModelMapper modelMapper ;

    @PostMapping("/add")

    public ResponseEntity<CategorieLanguedtos> createArticleLangue(@RequestBody CategorieLanguedtos categorieLanguedtos){
        CategorieLangue categorieLangue= modelMapper.map(categorieLanguedtos, CategorieLangue.class);
      categorieLangue.setLangue(iLangue.getOne(categorieLanguedtos.Langueid));
       categorieLangue.setCategorie(iCategorie.getOne(categorieLanguedtos.Categorieid));
       CategorieLangue created =iCategorieLangue.create(categorieLangue);
        return new ResponseEntity<>( modelMapper.map(created, CategorieLanguedtos.class), HttpStatus.CREATED);

    }
}
