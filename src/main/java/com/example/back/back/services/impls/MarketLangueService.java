package com.example.back.back.services.impls;

import com.example.back.back.entities.ArticleLangue;
import com.example.back.back.entities.MarketLangue;
import com.example.back.back.repositories.MarketLangueRepository;
import com.example.back.back.services.interfaces.IMarketLangue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MarketLangueService implements IMarketLangue {
    @Autowired
    private MarketLangueRepository marketLangueRepository;
    @Override
    public List<MarketLangue> getList() {
        return  marketLangueRepository.findAll();
    }
    @Override

    public MarketLangue getOne(Long id) {
        return  marketLangueRepository.findById(id).get();
    }

    @Override
    public MarketLangue create(MarketLangue marketLangue) {
        return  marketLangueRepository.save(marketLangue);
    }

    @Override
    public void deleteOne(Long id) {
        marketLangueRepository.deleteById(id);
    }

    @Override
    public MarketLangue update(MarketLangue marketLangue) {

        return  marketLangueRepository.save(marketLangue);
    }
}
