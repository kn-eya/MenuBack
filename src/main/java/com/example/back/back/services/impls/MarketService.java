package com.example.back.back.services.impls;

import com.example.back.back.dtos.CategorieResponseDto;
import com.example.back.back.entities.Categorie;
import com.example.back.back.entities.Langue;
import com.example.back.back.entities.Market;
import com.example.back.back.repositories.MarketRepository;
import com.example.back.back.services.interfaces.ICategorieLangue;
import com.example.back.back.services.interfaces.IMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarketService implements IMarket {
    @Autowired
    private MarketRepository marketRepository;
    @Autowired
   private   ICategorieLangue  iCategorieLangue ;
    @Override
    public List<Market> getList() {
        return marketRepository.findAll();
    }

    @Override
    public Market getOne(Long id) {
        return marketRepository.findById(id).get();
    }

    @Override
    public Market create(Market market) {
        return marketRepository.save(market);
    }

    @Override
    public void deleteOne(long id) {
         marketRepository.deleteById(id);
    }

    @Override
    public Market update(Market market) {

        return marketRepository.save(market);
    }

    @Override
    public List<CategorieResponseDto> getCategoeiesWithArticle(Long id) {
        Market market = this.getOne(id); // Récupérer le marché depuis le service

        List<Categorie> categories = market.getCategorieList().stream().filter(
                c->c.getNiveau()==0
        ).collect(Collectors.toList());

        // Construire l'arborescence
        List<CategorieResponseDto> categoriesArticle = categories.stream()
                .map(categorie -> mapCategorieToDTO(categorie))
                .collect(Collectors.toList());

        return categoriesArticle;
    }
    private CategorieResponseDto mapCategorieToDTO(Categorie categorie) {
        CategorieResponseDto categorieDTO = new CategorieResponseDto();
        categorieDTO.setId(categorie.getCategorieid());
        categorieDTO.setLibelle(categorie.getLibelle());
        categorieDTO.setArticles(categorie.getArticleList());
        categorieDTO.setNiveau(categorie.getNiveau());

        // Mapper les sous-catégories récursivement
        List<CategorieResponseDto> sousCategoriesDTO = categorie.getSousCategorie().stream()
                .map(sousCategorie -> mapCategorieToDTO(sousCategorie))
                .collect(Collectors.toList());
        categorieDTO.setSousCategorie(sousCategoriesDTO);

        return categorieDTO;
    }
   /* private String getTraductionCategorie (Categorie categorie , Langue langue)  {


    }*/
}
