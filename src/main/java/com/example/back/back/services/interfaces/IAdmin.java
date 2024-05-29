package com.example.back.back.services.interfaces;

import com.example.back.back.entities.Admin;


import java.util.List;

public interface IAdmin {
    public List<Admin> getList() ;
    public Admin getOne (Long id) ;
    public Admin  create(Admin admin) ;
    public  void deleteOne(Long id);
    public Admin update (Admin Admin);
}
