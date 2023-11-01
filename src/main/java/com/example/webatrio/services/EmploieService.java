package com.example.webatrio.services;



import com.example.webatrio.domain.Emploie;
import com.example.webatrio.domain.PersonneEmploie;

import java.time.LocalDate;
import java.util.List;

public interface EmploieService {
    Emploie save(Emploie emploie);
    List<Emploie> findAllEmploieBetwenTwoDate(Long PersonneId, String dateDeb, String dateFin);
}
