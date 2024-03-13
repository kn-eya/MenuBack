package com.example.back.back.repositories;

import com.example.back.back.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement,Long>, CrudRepository<Evenement,Long> {
}
