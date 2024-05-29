package com.example.back.back.security.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.back.back.entities.Admin;
import com.example.back.back.entities.Manager;
import com.example.back.back.security.dto.RoleUserForm;
import com.example.back.back.security.dto.UserRequestDto;
import com.example.back.back.security.entities.AppRole;
import com.example.back.back.security.entities.AppUser;
import com.example.back.back.security.services.IAccountService;
import com.example.back.back.security.utils.JwtUtil;
import com.example.back.back.services.interfaces.IAdmin;
import com.example.back.back.services.interfaces.IManager;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService _iAccountService ;
    @Autowired
    private IAdmin adminService ;
    @Autowired
    private IManager managerService ;
    @GetMapping("/users")
    public List<AppUser>  getAllUsers (){
      return   _iAccountService.users();
    }
    @GetMapping("/getByUserName/{userName}")
    public AppUser  getUserByUserName (@PathVariable String userName){

        return   _iAccountService.loadUserByUserName(userName);
    }

    @GetMapping("/managers/{username}")
    public List<Manager> getManagerByAdmin(@PathVariable String username){
        System.out.println(username);
        System.out.println("api manager");

        AppUser admin = this.getUserByUserName(username);
        return   managerService.getListByAdmin(admin);
    }
    @GetMapping("/admins")
    public List<Admin> getAdmins(){
        System.out.println("api admin");


        return   adminService.getList();
    }

    @PostMapping("/addUser")
    public  AppUser saveUser (@RequestBody AppUser appUser){
        return  _iAccountService.addNewUser(appUser);
    }

    @PostMapping("/addRole")
    public  AppRole saveRole (@RequestBody AppRole appRole){
        return  _iAccountService.addNewRole(appRole);
    }
    @PostMapping(path = "addRoleToUser")
    public  void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
         _iAccountService.addRoleToUser(roleUserForm.getUserName(),roleUserForm.getRoleName());
    }


    @GetMapping(path = "/refreshToken")
    public  void  refreshToken (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authToken = request.getHeader(JwtUtil.AUTH_HEADER);
        if(authToken!=null && authToken.startsWith(JwtUtil.PREFIX)){

            try {
                String jwt = authToken.substring(JwtUtil.PREFIX.length());
                System.out.println(jwt);
                Algorithm algorithm = Algorithm.HMAC256(JwtUtil.SECRET);
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();

                DecodedJWT decodedJWT =  jwtVerifier.verify(jwt);
                String userName= decodedJWT.getSubject();


                AppUser appUser = _iAccountService.loadUserByUserName(userName);
                String jwtAccesToken = JWT.create()
                        .withSubject(appUser.getUserName())
                        .withExpiresAt(new Date(System.currentTimeMillis()+JwtUtil.EXPIRE_ACCESS_TOKEN))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",appUser.getAppRoles().stream().map(
                                r->r.getRoleName()
                        ).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String,String> idToken= new HashMap<>();
                idToken.put("acces_token",jwtAccesToken);
                idToken.put("refresh_token",jwt);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(),idToken);

            }
            catch (Exception e)
            {
                throw  e ;
            }

        }
        else  {
            throw  new RuntimeException("Refresh Token Required");
        }


    }
    @GetMapping("/profile")
    public  AppUser profile(Principal principal) {
        return  _iAccountService.loadUserByUserName(principal.getName());
    }

    @PostMapping("/registre")
    public  void createUser(@RequestBody UserRequestDto userRequestDto){
        Admin admin;
        Manager manager  ;
        if(userRequestDto.getRoleName()=="Admin") {
            manager= new Manager() ;
            manager.setUserName(userRequestDto.getUserName());
            manager.setNom(userRequestDto.getNom());
            manager.setPassword(userRequestDto.getPassword());
            AppUser userConnectee=_iAccountService.loadUserByUserName(userRequestDto.getUserNameConnectee());
            manager.setAdmin(adminService.getOne(userConnectee.getId()));
            Manager managerSaved= managerService.create(manager);
            _iAccountService.addRoleToUser(managerSaved.getUserName(),"Manager");

        }
        else
        {
            admin = new Admin();
            admin.setUserName(userRequestDto.getUserName());
            admin.setNom(userRequestDto.getNom());
            admin.setPassword(userRequestDto.getPassword());
            Admin adminSavec = adminService.create(admin);
            _iAccountService.addRoleToUser(adminSavec.getUserName(),"Admin");

        }
    }











}
