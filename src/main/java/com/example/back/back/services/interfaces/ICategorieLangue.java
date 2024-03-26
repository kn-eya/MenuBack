package com.example.back.back.services.interfaces;

import com.example.back.back.entities.Categorie;
import com.example.back.back.entities.CategorieLangue;
import com.example.back.back.entities.Feedback;
import com.example.back.back.entities.Langue;

import java.util.List;

public interface ICategorieLangue {
   public List<CategorieLangue> getList();

  public   CategorieLangue getOne(Long id);

    public  CategorieLangue create(CategorieLangue categorieLangue);

    public void deleteOne(Long id);

   public CategorieLangue update(CategorieLangue categorieLangue);
   public  String  getTraductionCategorie (Categorie categorie , Langue langue) ;
}
