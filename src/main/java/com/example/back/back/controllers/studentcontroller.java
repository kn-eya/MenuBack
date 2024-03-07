package com.example.back.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping

public class studentcontroller {
    @Autowired
    

   @PostMapping("/List")
    public List<String> findallStudents(){
        return List.of(
             "Eya",
             "Hello"
        );

    };

}

