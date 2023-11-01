package com.example.webatrio.controller;


import com.example.webatrio.domain.Emploie;
import com.example.webatrio.domain.PersonneEmploie;
import com.example.webatrio.services.EmploieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/v1/emploie")
public class EmploieRessources {

    @Autowired
    private EmploieService emploieService;

    @PostMapping("/create")
    public ResponseEntity<Emploie> save(@RequestBody Emploie emploie) {
        return new ResponseEntity<>(emploieService.save(emploie), HttpStatus.OK);
    }

    @GetMapping("/emploie-person/{id}/{datedeb}/{datefin}")
    public ResponseEntity<List<Emploie>> getAllEmploieOfPerson(
            @PathVariable Long id, @PathVariable String datedeb, @PathVariable String datefin
            ){
        return new ResponseEntity<>(emploieService.findAllEmploieBetwenTwoDate(id, datedeb, datefin), HttpStatus.OK);
    }
}
