package com.example.back.back.repositories;
import com.example.back.back.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long>, CrudRepository<Commande, Long> {
}
