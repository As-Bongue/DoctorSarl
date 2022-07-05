package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.AffectationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AffectationRepository extends JpaRepository<AffectationService, Integer> {

}
