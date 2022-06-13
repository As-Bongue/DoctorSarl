package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierRepository extends JpaRepository<Dossier, Integer> {
}
