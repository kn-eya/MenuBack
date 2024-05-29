package com.example.back.back.services.impls;


import com.example.back.back.entities.SuperAdmin;

import com.example.back.back.repositories.SuperAdminRepository;
import com.example.back.back.services.interfaces.ISuperAdmin;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SuperAdminService implements ISuperAdmin {
    @Autowired
    private SuperAdminRepository superAdminRepository;

    @Override
    public List<SuperAdmin> getList() {
        return superAdminRepository.findAll();
    }
    @Override
    public  SuperAdmin getOne(Long id) {
        return superAdminRepository.findById(id).get();
    }

    @Override
    public  SuperAdmin create( SuperAdmin superAdmin) {
        return superAdminRepository.save(superAdmin);
    }

    @Override
    public void deleteOne(Long id) {
        superAdminRepository.deleteById(id);
    }

    @Override
    public SuperAdmin update(SuperAdmin superAdmin) {

        return superAdminRepository.save(superAdmin);
    }

}
