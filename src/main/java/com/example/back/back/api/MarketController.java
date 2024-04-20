package com.example.back.back.api;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.back.back.dtos.*;

import com.example.back.back.entities.Categorie;
import com.example.back.back.entities.Evenement;
import com.example.back.back.entities.Market;

import com.example.back.back.repositories.MarketRepository;
import com.example.back.back.services.impls.MarketService;
import com.example.back.back.services.interfaces.IMarket;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.util.ClassUtils.isPresent;

@RestController
@RequestMapping("/markets")

public class MarketController {
    @Autowired
    public IMarket iMarket;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MarketRepository marketRepository;


    @PostMapping("/add")
    public ResponseEntity<?> createArticle(@RequestBody Marketdtos marketdtos) {

            Market market = modelMapper.map(marketdtos, Market.class);
            Market saved = iMarket.create(market);
           return new ResponseEntity<>("Market created successfully", HttpStatus.CREATED);


    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findMarketById(@PathVariable Long id) throws Exception {
        try {
            Market market = iMarket.getOne(id);
            return new ResponseEntity<>(modelMapper.map(market, Marketdtos.class), HttpStatus.OK);
        }
        catch (Exception e){
            String errorMessage = "Market not found with ID: " + id;
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/all")
    public ResponseEntity<List<Marketdtos>> findMarkets() {
        List<Market> markets = iMarket.getList();
       List<Marketdtos> marketdtos = markets.stream()
               .map(market -> modelMapper.map(market,Marketdtos.class)).collect(Collectors.toList());

        return new ResponseEntity<>(marketdtos , HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMarket(@PathVariable Long id, @RequestBody Marketdtos updatedMarket) {
        try {
            Market market = iMarket.getOne(id);
            market.setLibelle(updatedMarket.getLibelle());
            market.setEmail(updatedMarket.getEmail());
            market.setLogo(updatedMarket.getLogo());
            market.setAddresse(updatedMarket.getAddresse());
            market.setPhonenumber(updatedMarket.getPhonenumber());
            market = marketRepository.save(market);

            return new ResponseEntity<>("Market updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Market not found ", HttpStatus.NOT_FOUND);
        }
    }



   @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            iMarket.getOne(id);
            iMarket.deleteOne(id);
            String message = "Market has been successfully deleted.";
            return new ResponseEntity<>(message , HttpStatus.OK);}
        catch (Exception e) {
         return new ResponseEntity<>("Market Id not found ", HttpStatus.NOT_FOUND);
    }}

    @GetMapping("/menu/{id}")
    public MenuResponseDto menu(@PathVariable Long id) {
        MenuResponseDto menu = new MenuResponseDto();
        Market market = iMarket.getOne(id); // Récupérer le marché depuis le service
        menu.setLibelle(market.getLibelle());
        menu.setAddresse(market.getAddresse());
        menu.setLogo(market.getLogo());
        menu.setPhonenumber(market.getPhonenumber());
        menu.setMedia(market.getMedia());
        menu.setEmail(market.getEmail());
        menu.setMenu(iMarket.getCategoeiesWithArticle(id));
        return menu;
    }



}

