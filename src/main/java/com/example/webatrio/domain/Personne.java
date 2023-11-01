package com.example.webatrio.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="PERSON")
public class Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name="nom")
   private String nom;
   private String prenom;
   private LocalDate dateNaissance;
   @JsonIgnore
   @OneToMany(mappedBy = "personne")
   private Set<PersonneEmploie> personneEmploie = new HashSet<>();
   @Transient
   private int age;
   @Transient
   private Emploie emploie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Set<PersonneEmploie> getPersonneEmploie() {
        return personneEmploie;
    }

    public void setPersonneEmploie(Set<PersonneEmploie> personneEmploie) {
        this.personneEmploie = personneEmploie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Emploie getEmploie() {
        return emploie;
    }

    public void setEmploie(Emploie emploie) {
        this.emploie = emploie;
    }


    public Personne(Long id, String nom, String prenom, LocalDate dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }
    public Personne() {

    }
}
