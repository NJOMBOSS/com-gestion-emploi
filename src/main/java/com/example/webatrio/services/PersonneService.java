package com.example.webatrio.services;

import com.example.webatrio.domain.Personne;
import com.example.webatrio.domain.PersonneEmploie;

import java.util.List;

public interface PersonneService {
     Personne save(Personne personne) throws Exception;
     PersonneEmploie addEmploieToPersonne(PersonneEmploie personneEmploie);
     List<Personne> getAllPersonne();

     List<Personne> findPersonneByGivenEntreprise(String nomEntreprise);
}
