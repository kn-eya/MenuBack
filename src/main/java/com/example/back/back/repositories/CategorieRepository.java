package com.example.back.back.repositories;

import com.example.back.back.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long>, CrudRepository<Categorie,Long> {

    Categorie findByLibelle(String libelle);
}
