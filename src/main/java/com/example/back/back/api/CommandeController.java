package com.example.back.back.api;

import com.example.back.back.dtos.Commandedtos;
import com.example.back.back.dtos.Feedbackdtos;
import com.example.back.back.dtos.Marketdtos;
import com.example.back.back.entities.Commande;
import com.example.back.back.entities.Market;
import com.example.back.back.services.interfaces.ICommande;
import com.example.back.back.services.interfaces.IFeedback;
import com.example.back.back.services.interfaces.IMarket;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("commandes")
public class CommandeController {
    @Autowired
    public ICommande iCommande;
    @Autowired
    public IMarket iMarket;
    @Autowired
    public IFeedback iFeedback;
    @Autowired
    private ModelMapper modelMapper ;

   @PostMapping("/create")
   public ResponseEntity<Commandedtos> createCommande(@RequestBody Commandedtos commandedtos){
       Commande commande= modelMapper.map(commandedtos,Commande.class);
       commande.setMarketcommande(iMarket.getOne(commandedtos.Marketid));

       Commande saved = iCommande.create(commande);
       Commandedtos comand= modelMapper.map(saved,Commandedtos.class);



       return new ResponseEntity<>(comand, HttpStatus.CREATED);


   }




    @GetMapping("/{id}")
    public ResponseEntity<Commandedtos> findCommandById(@PathVariable Long id){


        Commande commande= iCommande.getOne(id);

        return  new ResponseEntity<>( modelMapper.map(commande,Commandedtos.class), HttpStatus.OK);
    }

}
