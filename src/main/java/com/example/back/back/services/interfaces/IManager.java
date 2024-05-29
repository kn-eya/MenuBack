package com.example.back.back.services.interfaces;

import com.example.back.back.entities.Admin;
import com.example.back.back.entities.Manager;
import com.example.back.back.entities.Market;
import com.example.back.back.security.entities.AppUser;

import java.util.List;

public interface IManager {
    public List<Manager> getList() ;
    public Manager  getOne (Long id) ;

    public  Manager  create(Manager manager) ;
    public  void deleteOne(Long id);
    public  Manager update (Manager manager);
    List<Manager> getListByAdmin(AppUser admin);
}
