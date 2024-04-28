package com.example.back.back.api;

import com.example.back.back.dtos.Categoriedtos;

import com.example.back.back.dtos.Evenementdtos;
import com.example.back.back.entities.Categorie;

import com.example.back.back.entities.Evenement;
import com.example.back.back.repositories.CategorieRepository;
import com.example.back.back.services.interfaces.ICategorie;
import com.example.back.back.services.interfaces.IMarket;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("categories")

public class CategorieController {
    @Autowired
    public ICategorie iCategorie;
    @Autowired
    public IMarket iMarket;
    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    private CategorieRepository categorieRepository;

   @PostMapping("/add")
    public ResponseEntity<Categoriedtos> createCategorie(@RequestBody Categoriedtos categoriedtos){
        Categorie categorie = modelMapper.map(categoriedtos,Categorie.class);
        categorie.setMarket(iMarket.getOne(categoriedtos.Marketid));
        if(categoriedtos.getSupCategorieId()!=null) {
            categorie.setSupCategorie(iCategorie.getOne(categoriedtos.getSupCategorieId()));
        }
        Categorie saved = iCategorie.create(categorie);
        Categoriedtos catdtos=modelMapper.map(saved, Categoriedtos.class);
        catdtos.setMarketid(categorie.getMarket().getId());
        if(categoriedtos.getSupCategorieId()!=null) {
            catdtos.setSupCategorieId(categorie.getSupCategorie().getCategorieid());
        }
        return new ResponseEntity<>( catdtos, HttpStatus.CREATED);}

    @GetMapping("/get/{id}")
    public ResponseEntity<Categoriedtos> findCategorieById(@PathVariable Long id){


        Categorie categorie= iCategorie.getOne(id);
        Categoriedtos ctdos = modelMapper.map(categorie,Categoriedtos.class);

        try{

            ctdos.setSupCategorieId(categorie.getSupCategorie().getCategorieid());
        }catch (Exception e){


        }
        return  new ResponseEntity<>( ctdos, HttpStatus.OK);
}

@GetMapping("/all")
    public ResponseEntity<List<Categoriedtos>> findCategories() {
        List<Categorie> categories = iCategorie.getList();
        List<Categoriedtos> categorieDtos = categories.stream()
                .map(categorie -> modelMapper.map(categorie, Categoriedtos.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(categorieDtos, HttpStatus.OK);
    }
     /*  @GetMapping("/tt/{id}")
    public  ResponseEntity<Categorie>  tt(@PathVariable long id)  {
       return   new ResponseEntity<>(iCategorie.getOne(id),HttpStatus.OK);
    }

  @GetMapping("/tt2/{id}")
    public  ResponseEntity<Categoriedtos>  tt2(@PathVariable long id)  {
       Categorie categorie = iCategorie.getOne(id);
        return   new ResponseEntity<>(modelMapper.map(categorie,Categoriedtos.class),HttpStatus.OK);
    }*/
}
