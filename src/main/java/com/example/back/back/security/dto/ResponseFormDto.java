package com.example.back.back.security.dto;


import org.springframework.security.core.userdetails.User;

public class ResponseFormDto {
    private User user ;
    private String acces_token;
    private String refresh_token ;

    public ResponseFormDto() {
    }

    public ResponseFormDto(User user, String acces_token, String refresh_token) {
        this.user = user;
        this.acces_token = acces_token;
        this.refresh_token = refresh_token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAcces_token() {
        return acces_token;
    }

    public void setAcces_token(String acces_token) {
        this.acces_token = acces_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
