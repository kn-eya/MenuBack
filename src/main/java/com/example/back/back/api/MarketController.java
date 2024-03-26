package com.example.back.back.api;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.back.back.dtos.CategorieResponseDto;
import com.example.back.back.dtos.Marketdtos;

import com.example.back.back.dtos.MenuResponseDto;
import com.example.back.back.entities.Categorie;
import com.example.back.back.entities.Market;

import com.example.back.back.repositories.MarketRepository;
import com.example.back.back.services.interfaces.IMarket;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<Marketdtos> createArticle(@RequestBody Marketdtos marketdtos) {
        Market market = modelMapper.map(marketdtos, Market.class);
        Market saved = iMarket.create(market);
        return new ResponseEntity<>(modelMapper.map(saved, Marketdtos.class), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Marketdtos> findMarketById(@PathVariable Long id) {


        Market market = iMarket.getOne(id);

        return new ResponseEntity<>(modelMapper.map(market, Marketdtos.class), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Market> tt(@PathVariable long id) {
        return new ResponseEntity<>(iMarket.getOne(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Marketdtos> updateMarket(@PathVariable Long id, @RequestBody Marketdtos updatedMarket) {
        Market market = modelMapper.map(updatedMarket, Market.class);
        market.setId(id);
        market = marketRepository.save(market);
        updatedMarket = modelMapper.map(market, Marketdtos.class);
        return new ResponseEntity<>(updatedMarket, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        iMarket.deleteOne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


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

