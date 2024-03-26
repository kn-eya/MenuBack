package com.example.back.back.services.impls;
import com.example.back.back.entities.Categorie;
import com.example.back.back.entities.CategorieLangue;
import com.example.back.back.entities.Langue;
import com.example.back.back.repositories.CategorieLangueRepository;
import com.example.back.back.services.interfaces.ICategorieLangue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CategorieLangueService implements ICategorieLangue {
    @Autowired
    private CategorieLangueRepository categorieLangueRepository;
    @Override
    public List<CategorieLangue> getList() {
        return categorieLangueRepository.findAll();
    }
    @Override

    public CategorieLangue getOne(Long id) {
        return categorieLangueRepository.findById(id).get();
    }

    @Override
    public CategorieLangue create( CategorieLangue  categorieLangue) {
        return categorieLangueRepository.save(categorieLangue);
    }

    @Override
    public void deleteOne(Long id) {
        categorieLangueRepository.deleteById(id);
    }

    @Override
    public CategorieLangue update(CategorieLangue categorieLangue) {

        return categorieLangueRepository.save(categorieLangue);
    }

    @Override
    public String getTraductionCategorie(Categorie categorie, Langue langue) {
        return this.getList().stream().filter(cl
                ->cl.getCategorie().getCategorieid()== categorie.getCategorieid() &&
                cl.getLangue().getId()==langue.getId()
        ).collect(Collectors.toList()).get(0).getTraduction();


    }


}
