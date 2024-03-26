package com.example.back.back.repositories;

import com.example.back.back.entities.CategorieLangue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategorieLangueRepository extends JpaRepository<CategorieLangue,Long> , CrudRepository<CategorieLangue,Long> {


}
