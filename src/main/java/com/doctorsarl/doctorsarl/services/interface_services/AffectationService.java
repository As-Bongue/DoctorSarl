package com.doctorsarl.doctorsarl.services.interface_services;


import java.util.List;

public interface AffectationService {

    com.doctorsarl.doctorsarl.entities.AffectationService saveAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff);
    com.doctorsarl.doctorsarl.entities.AffectationService updateAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff);
    void deleteAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff);
    void deleteById(int id);
    com.doctorsarl.doctorsarl.entities.AffectationService getAffectation(int id);
    List<com.doctorsarl.doctorsarl.entities.AffectationService> getAllAffectation();
}
