package com.example.back.back.security.repositories;

import com.example.back.back.security.entities.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userNAme);
}
