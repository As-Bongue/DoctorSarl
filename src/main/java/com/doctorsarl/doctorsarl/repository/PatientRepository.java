package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
