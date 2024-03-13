package com.example.back.back.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Feedbackid;
    private String message;
    private Boolean visible;
    @ManyToOne
    private Market marketfeedback;

}
