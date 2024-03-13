package com.example.back.back.repositories;

import com.example.back.back.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
@Repository
public interface ArticleRepository  extends JpaRepository<Article,Long>, CrudRepository<Article, Long>  {





}
