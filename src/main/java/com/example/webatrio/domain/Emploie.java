package com.example.webatrio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="EMPLOIE")
public class Emploie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emploie_id")
    private Long id;
    private String nomEntreprise;
    private String poste;
    @JsonIgnore
    @OneToMany(mappedBy = "emploie")
    private Set<PersonneEmploie> personneEmploies = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Set<PersonneEmploie> getPersonneEmploies() {
        return personneEmploies;
    }

    public void setPersonneEmploies(Set<PersonneEmploie> personneEmploies) {
        this.personneEmploies = personneEmploies;
    }
}
