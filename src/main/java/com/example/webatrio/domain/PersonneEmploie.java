package com.example.webatrio.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity @AllArgsConstructor @NoArgsConstructor
@Table(name= "PERSON_EMPLOIE")
public class PersonneEmploie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pe_id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person")
    private Personne personne;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="emploie")
    private Emploie emploie;

    @Column(name="DATE_DEBUT")
    private LocalDate dateDebut;
    @Column(name="DATE_FIN")
    private LocalDate dateFin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Emploie getEmploie() {
        return emploie;
    }

    public void setEmploie(Emploie emploie) {
        this.emploie = emploie;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}
