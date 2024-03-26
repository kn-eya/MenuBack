package com.example.back.back.dtos;

import java.time.LocalDateTime;

public class Evenementdtos {
    private Long id;
    private String description;
    private LocalDateTime datetHeureD;
    private LocalDateTime datetHeureF;
    private  String file;
    private Long Marketid;

    public Evenementdtos() {
    }

    public Evenementdtos(Long id, String description, LocalDateTime datetHeureD, LocalDateTime datetHeureF, String file, Long marketid) {
        this.id = id;
        this.description = description;
        this.datetHeureD = datetHeureD;
        this.datetHeureF = datetHeureF;
        this.file = file;
        Marketid = marketid;
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

    public Long getMarketid() {
        return Marketid;
    }

    public void setMarketid(Long marketid) {
        Marketid = marketid;
    }
}
