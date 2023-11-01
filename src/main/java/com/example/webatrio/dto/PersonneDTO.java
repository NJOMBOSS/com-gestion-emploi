package com.example.webatrio.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonneDTO {
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int age;
}
