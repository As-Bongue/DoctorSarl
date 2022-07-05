package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonnelMedicalRepository extends JpaRepository<PersonnelMedical, Integer> {

}
