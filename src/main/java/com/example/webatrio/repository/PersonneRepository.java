package com.example.webatrio.repository;

import com.example.webatrio.domain.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Collection;


public interface PersonneRepository extends JpaRepository<Personne, Long> {

    @Query(
            value = "SELECT p.id, nom, prenom, DATE_NAISSANCE, emploie, DATE_DEBUT as dateDebut, DATE_FIN as dateFin FROM PERSON p  join PERSON_EMPLOIE pe on p.ID = pe.person " +
                    "where pe.DATE_FIN > CURRENT_DATE" +
                    " order by p.nom asc",
            nativeQuery = true)
    Collection<Personne> findAllPersonneWithAgeAndEmloie();


    Collection<Personne> findByPersonneEmploieDateFinGreaterThanOrderByNom(LocalDate date);

}

