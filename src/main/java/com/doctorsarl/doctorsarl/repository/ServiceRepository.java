package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
