package com.example.back.back.security.entities;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="User_type",
        discriminatorType = DiscriminatorType.INTEGER)
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
    private String nom ;
    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> appRoles= new ArrayList<>();

    public AppUser(Long id, String nom, String userName, String password, Collection<AppRole> appRoles) {
        Id = id;
        this.nom = nom;
        this.userName = userName;
        this.password = password;
        this.appRoles = appRoles;
    }

    public AppUser() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<AppRole> getAppRoles() {
        return appRoles;
    }

    public void setAppRoles(Collection<AppRole> appRoles) {
        this.appRoles = appRoles;
    }
}
