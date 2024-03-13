package com.example.back.back.controllers;

import com.example.back.back.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD:src/main/java/com/example/back/back/controllers/EvenementController.java
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> fca6f5c0bb9d15e3706442a9c933686c983badd9:src/main/java/com/example/back/back/controllers/studentcontroller.java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping

public class EvenementController {
    @Autowired
<<<<<<< HEAD:src/main/java/com/example/back/back/controllers/EvenementController.java
    private EvenementService evenementService;
=======
    

   @PostMapping("/List")
    public List<String> findallStudents(){
        return List.of(
             "Eya",
             "Hello"
        );

    };
>>>>>>> fca6f5c0bb9d15e3706442a9c933686c983badd9:src/main/java/com/example/back/back/controllers/studentcontroller.java

}

