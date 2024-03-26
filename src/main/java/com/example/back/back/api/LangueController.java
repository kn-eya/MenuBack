package com.example.back.back.api;

import com.example.back.back.dtos.Commandedtos;
import com.example.back.back.dtos.Languedtos;
import com.example.back.back.dtos.Marketdtos;
import com.example.back.back.entities.Commande;
import com.example.back.back.entities.Langue;
import com.example.back.back.entities.Market;
import com.example.back.back.services.interfaces.ILangue;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Langues")

public class LangueController {
    @Autowired
    public ILangue iLangue;
    @Autowired
    private ModelMapper modelMapper ;

   @PostMapping("/langue")
    public ResponseEntity<Languedtos> createArticle(@RequestBody Languedtos languedtos){
       Langue langue = modelMapper.map(languedtos,Langue.class);
        Langue saved = iLangue.create(langue);
        return new ResponseEntity<>( modelMapper.map(saved, Languedtos.class), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Languedtos> findCommandById(@PathVariable Long id){


        Langue langue= iLangue.getOne(id);

        return  new ResponseEntity<>( modelMapper.map(langue,Languedtos.class), HttpStatus.OK);
    }
}
