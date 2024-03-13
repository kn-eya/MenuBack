package com.example.back.back.controllers;

import com.example.back.back.entities.Market;
import com.example.back.back.services.Marketservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/markets")
public class MarketController {
   @Autowired
   private Marketservice marketservice;
   @PostMapping("/market")
    public  ResponseEntity<Market> createMarket(@RequestBody Market market){
   Market createdMarket = marketservice.createMarket(market.getLibelle(), market.getPhonenumber(), market.getAddresse(), market.getEmail(), market.getLogo(), market.getMedia());
   return ResponseEntity.ok(createdMarket);
}


}
