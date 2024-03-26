package com.example.back.back.repositories;

import com.example.back.back.entities.MarketLangue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketLangueRepository extends JpaRepository<MarketLangue,Long>, CrudRepository<MarketLangue,Long> {
}
