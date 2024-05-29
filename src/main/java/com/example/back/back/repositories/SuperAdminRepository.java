package com.example.back.back.repositories;


import com.example.back.back.entities.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SuperAdminRepository extends JpaRepository<SuperAdmin,Long>, CrudRepository<SuperAdmin, Long> {
}
