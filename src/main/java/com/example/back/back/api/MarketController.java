package com.example.back.back.api;

import com.example.back.back.dtos.*;

import com.example.back.back.entities.Admin;
import com.example.back.back.entities.Market;

import com.example.back.back.repositories.MarketRepository;
import com.example.back.back.security.services.IAccountService;
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
    @Autowired
    private IAccountService _iAccountService;

    @PostMapping("/add")
    public ResponseEntity< Marketdtos> createArticle(@RequestBody Marketdtos marketdtos) {

            Market market = modelMapper.map(marketdtos, Market.class);
            Admin admin =  (Admin) _iAccountService.loadUserByUserName(marketdtos.adminUserName);
            market.setAdmin(admin);
            Market saved = iMarket.create(market);
           return new ResponseEntity<>( modelMapper.map(saved, Marketdtos.class), HttpStatus.CREATED);


    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findMarketById(@PathVariable Long id) throws Exception {

            Market market = iMarket.getOne(id);
            return new ResponseEntity<>(modelMapper.map(market, Marketdtos.class), HttpStatus.OK);



    }


    @GetMapping("/all")
    public ResponseEntity<List<Marketdtos>> findMarkets() {
        List<Market> markets = iMarket.getList();
       List<Marketdtos> marketdtos = markets.stream()
               .map(market -> modelMapper.map(market,Marketdtos.class)).collect(Collectors.toList());

        return new ResponseEntity<>(marketdtos , HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Marketdtos> updateMarket(@PathVariable Long id, @RequestBody Marketdtos updatedMarket) {

            Market market = iMarket.getOne(id);
            market.setLibelle(updatedMarket.getLibelle());
            market.setEmail(updatedMarket.getEmail());
            market.setLogo(updatedMarket.getLogo());
            market.setAddresse(updatedMarket.getAddresse());
            market.setPhonenumber(updatedMarket.getPhonenumber());
            market = marketRepository.save(market);

            return new ResponseEntity<>(modelMapper.map( market, Marketdtos.class), HttpStatus.OK);

    }



   @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

            iMarket.getOne(id);
            iMarket.deleteOne(id);
         return new ResponseEntity<>( HttpStatus.OK);
   }

    @GetMapping("/menu/{id}")
    public ResponseEntity<MenuResponseDto> menu(@PathVariable Long id) {
        MenuResponseDto menu = new MenuResponseDto();
        Market market = iMarket.getOne(id); // Récupérer le marché depuis le service
        menu.setLibelle(market.getLibelle());
        menu.setAddresse(market.getAddresse());
        menu.setLogo(market.getLogo());
        menu.setPhonenumber(market.getPhonenumber());
        menu.setMedia(market.getMedia());
        menu.setEmail(market.getEmail());
        menu.setMenu(iMarket.getCategoeiesWithArticle(id));
        return new  ResponseEntity<MenuResponseDto> (menu,HttpStatus.OK);
    }

    @GetMapping("/getByUserName/{userName}")
    public ResponseEntity<List<Marketdtos>> findMarketsByUserName(@PathVariable String userName) {
        List<Market> markets = iMarket.findMarketsbyUserName(userName);
        List<Marketdtos> marketdtos = markets.stream()
                .map(market -> modelMapper.map(market,Marketdtos.class)).collect(Collectors.toList());

        return new ResponseEntity<>(marketdtos , HttpStatus.OK);
    }



}

