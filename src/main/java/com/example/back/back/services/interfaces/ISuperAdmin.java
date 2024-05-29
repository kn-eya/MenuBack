package com.example.back.back.services.interfaces;


import com.example.back.back.entities.SuperAdmin;

import java.util.List;

public interface ISuperAdmin {
    public List<SuperAdmin> getList() ;
    public SuperAdmin getOne (Long id) ;
    public SuperAdmin  create(SuperAdmin superAdmin) ;
    public  void deleteOne(Long id);
    public SuperAdmin update (SuperAdmin superAdmin);
}
