package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {

    Personne findByEmail(String email);
}
