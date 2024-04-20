package com.example.back.back.security.services;

import com.example.back.back.security.entities.*;

import java.util.List;

public interface IAccountService {
    AppUser addNewUser (AppUser appUser) ;
    AppUser updateUser (AppUser appUser) ;
    AppRole addNewRole (AppRole appRole);
    void addRoleToUser(String userName, String roleName);
    AppUser loadUserByUserName(String UserName);
    List<AppUser> users () ;
}
