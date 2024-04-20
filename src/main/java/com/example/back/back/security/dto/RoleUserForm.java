package com.example.back.back.security.dto;



public class RoleUserForm {
    private  String userName;
    private  String roleName ;

    public RoleUserForm() {
    }

    public RoleUserForm(String userName, String roleName) {
        this.userName = userName;
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
