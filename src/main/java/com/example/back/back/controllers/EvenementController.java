package com.example.back.back.controllers;

import com.example.back.back.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class EvenementController {
    @Autowired
    private EvenementService evenementService;

}
