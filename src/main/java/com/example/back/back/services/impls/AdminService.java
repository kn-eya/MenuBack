package com.example.back.back.services.impls;

import com.example.back.back.entities.Admin;

import com.example.back.back.repositories.AdminRepository;

import com.example.back.back.repositories.ManagerRepository;
import com.example.back.back.services.interfaces.IAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService implements IAdmin {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public List<Admin> getList() {
        return adminRepository.findAll();
    }
    @Override
    public  Admin getOne(Long id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public  Admin create( Admin admin) {
        String pw = admin.getPassword();
        admin.setPassword(bCryptPasswordEncoder.encode(pw));
        return adminRepository.save(admin);
    }

    @Override
    public void deleteOne(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin update(Admin admin) {

        return adminRepository.save(admin);
    }


}
