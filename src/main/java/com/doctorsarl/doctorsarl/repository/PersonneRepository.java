package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Personne;
import com.doctorsarl.doctorsarl.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
//    @Query("SELECT p FROM Personne p WHERE p.nom = :nom")
//    public Personne getUserByUsername(@Param("username") String username);
    Personne findByEmail(String email);
}
