package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DossierRepository extends JpaRepository<Dossier, Integer> {
    Dossier findByCode(String code);

}
