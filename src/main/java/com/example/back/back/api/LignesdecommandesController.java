package com.example.back.back.api;

import com.example.back.back.dtos.Lignedecommandesdtos;
import com.example.back.back.dtos.Marketdtos;
import com.example.back.back.entities.Lignedecommandes;
import com.example.back.back.entities.Market;
import com.example.back.back.services.interfaces.IArticle;
import com.example.back.back.services.interfaces.ICommande;
import com.example.back.back.services.interfaces.ILignedecommandes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lc")
public class LignesdecommandesController {
    @Autowired
    public IArticle iArticle;
    @Autowired
    public ICommande iCommande;
    @Autowired
    public ILignedecommandes iLignedecommandes;
    @Autowired
    private ModelMapper modelMapper ;
    private org.springframework.http.ResponseEntity<Lignedecommandesdtos> ResponseEntity;
    @PostMapping("/add")

    public ResponseEntity<Lignedecommandesdtos> createlignedecommandes(@RequestBody Lignedecommandesdtos lignedecommandesdtos){
        Lignedecommandes lignedecommandes=modelMapper.map(lignedecommandesdtos,Lignedecommandes.class);
        lignedecommandes.setCommande(iCommande.getOne(lignedecommandesdtos.Commandeid));
        lignedecommandes.setArticle(iArticle.getOne(lignedecommandesdtos.Articleid));
       // lignedecommandes.setTotalPrix(lignedecommandes.getQuantite() * lignedecommandes.getArticle().getPrix());
        Lignedecommandes create=iLignedecommandes.create(lignedecommandes);
        return new ResponseEntity<>(modelMapper.map(create,Lignedecommandesdtos.class), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Lignedecommandesdtos> findId(@PathVariable Long id){


        Lignedecommandes lignedecommandes = iLignedecommandes.getOne(id);

        return  new ResponseEntity<>( modelMapper.map(lignedecommandes,Lignedecommandesdtos.class), HttpStatus.OK);
    }

}
