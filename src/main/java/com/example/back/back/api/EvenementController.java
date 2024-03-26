package com.example.back.back.api;

import com.example.back.back.dtos.Commandedtos;
import com.example.back.back.dtos.Evenementdtos;
import com.example.back.back.entities.Commande;
import com.example.back.back.entities.Evenement;
import com.example.back.back.services.interfaces.IEvenement;
import com.example.back.back.services.interfaces.IMarket;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evenements")
public class EvenementController {
    @Autowired
    public IEvenement iEvenement;
    @Autowired
    public IMarket iMarket;
    @Autowired
    private ModelMapper modelMapper ;
    @PostMapping("/created")
    public ResponseEntity<Evenementdtos> createEvenement(@RequestBody Evenementdtos evenementdtos){
        Evenement evenement = modelMapper.map(evenementdtos,Evenement.class);
         evenement.setMarketevenement(iMarket.getOne(evenementdtos.getMarketid()));
         Evenement created= iEvenement.create(evenement);
         return new ResponseEntity<>(modelMapper.map(created,Evenementdtos.class), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Evenementdtos> findEvenementById(@PathVariable Long id){


        Evenement evenement= iEvenement.getOne(id);

        return  new ResponseEntity<>( modelMapper.map(evenement,Evenementdtos.class), HttpStatus.OK);
    }
    @GetMapping("/allevenement")
    public ResponseEntity<List<Evenementdtos>> findEvenements() {
        List<Evenement> evenements = iEvenement.getList();
        List<Evenementdtos> evenementDtos = evenements.stream()
                .map(evenement -> modelMapper.map(evenement, Evenementdtos.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(evenementDtos, HttpStatus.OK);
    }
}
