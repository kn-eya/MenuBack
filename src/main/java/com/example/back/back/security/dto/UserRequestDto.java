package com.example.back.back.security.dto;

public class UserRequestDto {
    private  String nom ;
    private  String userName ;
    private String password ;
    private String roleName;
    private String UserNameConnectee;

    public UserRequestDto() {
    }

    public String getUserNameConnectee() {
        return UserNameConnectee;
    }

    public void setUserNameConnectee(String userNameConnectee) {
        UserNameConnectee = userNameConnectee;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
