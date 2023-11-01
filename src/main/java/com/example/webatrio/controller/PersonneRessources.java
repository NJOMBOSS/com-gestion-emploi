package com.example.webatrio.controller;


import com.example.webatrio.domain.Personne;
import com.example.webatrio.domain.PersonneEmploie;
import com.example.webatrio.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personnes")
public class PersonneRessources {

    @Autowired
   private PersonneService  personneService;

    @PostMapping("/create")
    public ResponseEntity<Personne> save(@RequestBody Personne personne) throws Exception {
        return new ResponseEntity<>(personneService.save(personne), HttpStatus.OK);
    }

    @PostMapping("/add-emploi")
    public ResponseEntity<PersonneEmploie> addEmploieToPerson(@RequestBody PersonneEmploie personneEmploie){
        return new ResponseEntity<>(personneService.addEmploieToPersonne(personneEmploie), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Personne>> getAllPersonByCriteria(){
        return new ResponseEntity<>(personneService.getAllPersonne(), HttpStatus.OK);
    }

    @GetMapping("/personnes-per-entreprise/{name}")
    public ResponseEntity<List<Personne>> getPersonByEnterpriseName(@PathVariable String name){
        return new ResponseEntity<>(personneService.findPersonneByGivenEntreprise(name), HttpStatus.OK);
    }
}
