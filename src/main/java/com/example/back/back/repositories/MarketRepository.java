package com.example.back.back.repositories;
import com.example.back.back.entities.Market;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarketRepository extends JpaRepository<Market,Long>, CrudRepository<Market, Long> {
    void deleteById(Long ID);


}
