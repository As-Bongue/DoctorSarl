package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Service findByNom(String nom);

}
