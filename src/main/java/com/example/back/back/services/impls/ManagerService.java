package com.example.back.back.services.impls;


import com.example.back.back.entities.Admin;
import com.example.back.back.entities.Manager;
import com.example.back.back.repositories.ManagerRepository;
import com.example.back.back.security.entities.AppUser;
import com.example.back.back.security.services.IAccountService;
import com.example.back.back.services.interfaces.IManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerService implements IManager {


    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<Manager> getList() {
        return managerRepository.findAll();
    }
    @Override
    public   Manager getOne(Long id) {
        return managerRepository.findById(id).get();
    }

    @Override
    public   Manager create(  Manager manager) {
        String pw = manager.getPassword();
        manager.setPassword(bCryptPasswordEncoder.encode(pw));
        return managerRepository.save(manager);
    }

    @Override
    public void deleteOne(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public Manager update(Manager manager) {

        return managerRepository.save(manager);
    }



    @Override
    public List<Manager> getListByAdmin(AppUser admin) {

        return managerRepository.findAll().stream().filter(m->m.getAdmin()!=null).filter(m->m.getAdmin().getId()==admin.getId()).collect(Collectors.toList());
    }

}
