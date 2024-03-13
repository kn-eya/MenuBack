package com.example.back.back.controllers;

import com.example.back.back.entities.Article;
import com.example.back.back.entities.Commande;
import com.example.back.back.services.Commandservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {
    @Autowired
    private Commandservice commandservice;
    @GetMapping("/listedecommande")

    public ResponseEntity<List<Commande>> getAllCommandes()
    {List<Commande> commandes = commandservice.getAllCommandes();
        return ResponseEntity.ok(commandes);

    }
    @PostMapping("/commande")
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        Commande createdCommande = commandservice.createCommande(commande.getReference(),commande.getTablenumb(),commande.getName(),commande.getStatuscommand());
        if (createdCommande != null) {
            return ResponseEntity.ok(createdCommande);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
