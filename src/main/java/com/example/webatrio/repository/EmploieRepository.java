package com.example.webatrio.repository;

import com.example.webatrio.domain.Emploie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmploieRepository extends JpaRepository<Emploie, Long> {

    Emploie findAllByNomEntrepriseLike(String nom);

}

