package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
