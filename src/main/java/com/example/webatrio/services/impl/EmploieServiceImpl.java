package com.example.webatrio.services.impl;

import com.example.webatrio.domain.Emploie;
import com.example.webatrio.domain.PersonneEmploie;
import com.example.webatrio.repository.EmploieRepository;
import com.example.webatrio.repository.PersonneEmploieRepository;
import com.example.webatrio.services.EmploieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmploieServiceImpl implements EmploieService {

    @Autowired
    private EmploieRepository emploieRepository;

    @Autowired
    private PersonneEmploieRepository personneEmploieRepository;
    /**
     * @param emploie
     * @return
     */
    @Override
    public Emploie save(Emploie emploie) {
        return emploieRepository.save(emploie);
    }

    /**
     * @param personneId
     * @param dateDeb
     * @param dateFin
     * @return
     */
    @Override
    public List<Emploie> findAllEmploieBetwenTwoDate(Long personneId, String dateDeb, String dateFin) {
        var dateStart = LocalDate.parse(dateDeb);
        var dateEnd = LocalDate.parse(dateFin);
       return personneEmploieRepository.findByPersonneIdAndDateDebutBetween(personneId, dateStart, dateEnd)
               .stream().map(p -> p.getEmploie()).toList();

    }

}
