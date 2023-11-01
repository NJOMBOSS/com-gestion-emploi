package com.example.webatrio.services.impl;

import com.example.webatrio.domain.Personne;
import com.example.webatrio.domain.PersonneEmploie;
import com.example.webatrio.repository.EmploieRepository;
import com.example.webatrio.repository.PersonneEmploieRepository;
import com.example.webatrio.repository.PersonneRepository;
import com.example.webatrio.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private EmploieRepository emploieRepository;

    @Autowired
    private PersonneEmploieRepository personneEmploieRepository;


    /**
     * @param personne
     * @return
     */
    @Override
    public Personne save(Personne personne) throws Exception {
        int age = LocalDate.now().getYear() - personne.getDateNaissance().getYear();
        if(age>150){
            throw new Exception("age trop supérieur");
        }
        return personneRepository.save(personne);
    }

    /**
     * @param personneEmploie
     */
    @Override
    public PersonneEmploie addEmploieToPersonne(PersonneEmploie personneEmploie) {
        return personneEmploieRepository.save(personneEmploie);
    }

    /**
     * @return
     */
    @Override
    public List<Personne> getAllPersonne() {
       List<PersonneEmploie> persons =  personneEmploieRepository.findAll();
        persons.forEach(p -> p.getPersonne().setEmploie(p.getEmploie()));
        persons.forEach(p -> p.getPersonne().setAge(LocalDate.now().getYear() - p.getPersonne().getDateNaissance().getYear()));
      //  persons.forEach(p -> p.setAge(LocalDate.now().getYear() - p.getDateNaissance().getYear()));
        return persons.stream().map(p -> p.getPersonne()).toList();
    }


    /**
     * @param nomEntreprise
     * @return
     */
    @Override
    public List<Personne> findPersonneByGivenEntreprise(String nomEntreprise) {
        List<Personne> personnes = (List<Personne>) personneEmploieRepository.findPersonneByGivenEntreprise(nomEntreprise);
        personnes.forEach(p -> p.setAge(LocalDate.now().getYear() - p.getDateNaissance().getYear()));
        return personnes;
    }
}
