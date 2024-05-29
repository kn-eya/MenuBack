package com.example.back.back.repositories;

import com.example.back.back.entities.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository  extends JpaRepository<Admin,Long>, CrudRepository<Admin, Long> {
}
