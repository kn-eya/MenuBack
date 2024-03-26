package com.example.back.back.repositories;

import com.example.back.back.entities.Langue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangueRepository extends JpaRepository<Langue,Long> , CrudRepository<Langue,Long> {
}
