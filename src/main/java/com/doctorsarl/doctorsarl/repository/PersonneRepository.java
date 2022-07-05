package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {

    Personne findByEmail(String email);
}
