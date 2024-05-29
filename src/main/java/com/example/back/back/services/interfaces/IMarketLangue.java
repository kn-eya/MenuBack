package com.example.back.back.services.interfaces;


import com.example.back.back.entities.MarketLangue;

import java.util.List;

public interface IMarketLangue {
    public List<MarketLangue > getList() ;
    public MarketLangue  getOne (Long id) ;
    public  MarketLangue  create(MarketLangue marketLangue) ;
    public  void deleteOne(Long id);
    public MarketLangue update (MarketLangue marketLangue);
}
