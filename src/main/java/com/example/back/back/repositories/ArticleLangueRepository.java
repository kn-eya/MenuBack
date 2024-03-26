package com.example.back.back.repositories;

import com.example.back.back.entities.ArticleLangue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArticleLangueRepository extends JpaRepository<ArticleLangue,Long> , CrudRepository<ArticleLangue,Long> {
}
