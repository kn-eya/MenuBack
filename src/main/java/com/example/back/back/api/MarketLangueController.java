package com.example.back.back.api;

import com.example.back.back.dtos.CategorieLanguedtos;
import com.example.back.back.dtos.MarketLanguedtos;
import com.example.back.back.entities.CategorieLangue;
import com.example.back.back.entities.MarketLangue;
import com.example.back.back.services.interfaces.ILangue;
import com.example.back.back.services.interfaces.IMarket;
import com.example.back.back.services.interfaces.IMarketLangue;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ml")
public class MarketLangueController {
    @Autowired
    public IMarket iMarket;
    @Autowired
    public ILangue iLangue;
    @Autowired
    public IMarketLangue iMarketLangue;
    @Autowired
    private ModelMapper modelMapper ;
    @PostMapping("/add")

    public ResponseEntity<MarketLanguedtos> createArticleLangue(@RequestBody MarketLanguedtos marketLanguedtos){
        MarketLangue marketLangue= modelMapper.map(marketLanguedtos, MarketLangue.class);
        marketLangue.setLangue (iLangue.getOne(marketLanguedtos.Langueid));
        marketLangue.setMarket(iMarket.getOne(marketLanguedtos.Marketid));
        MarketLangue created =iMarketLangue.create(marketLangue);
        return new ResponseEntity<>( modelMapper.map(created, MarketLanguedtos.class), HttpStatus.CREATED);

    }
}
