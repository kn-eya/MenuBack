package com.example.back.back.repositories;


import com.example.back.back.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long>, CrudRepository<Manager, Long> {
}
