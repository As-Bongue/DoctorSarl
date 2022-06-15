package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
