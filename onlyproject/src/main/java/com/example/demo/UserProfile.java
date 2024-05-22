package com.example.demo;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "profile")
public class UserProfile {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    @NotBlank
    private String teamName;
    
    @Column(nullable = false)
    @NotBlank
    private String sport;
    
    @Column(nullable = false)
    @NotBlank
    private String activityFrequency;
    
    @Column(nullable = false)
    @NotBlank
    private LocalDate matchDate;
    
    @Column(nullable = false)
    @NotBlank
    private String PR;
    
    // Getters and setters
}
