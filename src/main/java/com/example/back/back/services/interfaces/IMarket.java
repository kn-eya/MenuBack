package com.example.back.back.services.interfaces;

import com.example.back.back.dtos.CategorieResponseDto;
import com.example.back.back.entities.Market;
import org.apache.el.stream.Optional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IMarket {
    public List<Market> getList() ;
    public Market  getOne (Long id) ;

    public  Market  create(Market market) ;
    public  void deleteOne(Long id);
    public  Market update (Market market);

    public List<CategorieResponseDto> getCategoeiesWithArticle(@PathVariable Long id);
    public  Market findByEmail(String email);



}
