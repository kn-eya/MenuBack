package com.example.back.back.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity

public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime datetHeureD;
    private LocalDateTime datetHeureF;
    private  String file;
@ManyToOne
private Market marketevenement;
    public Evenement() {
    }

    public Evenement(Long id, String description,LocalDateTime datetHeureD, LocalDateTime datetHeureF, String file) {
        this.id = id;
        this.description = description;
        this.datetHeureD = datetHeureD;
        this.datetHeureF = datetHeureF;
        this.file = file;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDatetHeureD() {
        return datetHeureD;
    }

    public void setDatetHeureD(LocalDateTime datetHeureD) {
        this.datetHeureD = datetHeureD;
    }

    public LocalDateTime getDatetHeureF() {
        return datetHeureF;
    }

    public void setDatetHeureF(LocalDateTime datetHeureF) {
        this.datetHeureF = datetHeureF;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
