package com.example.webatrio.repository;

import com.example.webatrio.domain.Personne;
import com.example.webatrio.domain.PersonneEmploie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface PersonneEmploieRepository extends JpaRepository<PersonneEmploie, Long> {

//    @Query(
//            value = "select * from PERSON as p left join PERSON_EMPLOIE as pe on p.id = pe.person left join EMPLOIE as e on pe.emploie = e.emploie_id " +
//                    " where e.NOM_Entreprise = :#{#nomEntreprise}",
//            nativeQuery = true)
//    Collection<Personne> findPersonneByGivenEntreprise(@Param("nomEntreprise") String nomEntreprise);

    @Query("Select new Personne(p.id, p.nom, p.prenom, p.dateNaissance) from Personne p, PersonneEmploie pe, Emploie e where p.id = pe.personne.id and pe.emploie.id = e.id and e.nomEntreprise = :#{#nomEntreprise}")
    Collection<Personne> findPersonneByGivenEntreprise(@Param("nomEntreprise") String nomEntreprise);

    List<PersonneEmploie> findByPersonneIdAndDateDebutBetween(Long personneId, LocalDate dateDeb, LocalDate dateFin);
}
