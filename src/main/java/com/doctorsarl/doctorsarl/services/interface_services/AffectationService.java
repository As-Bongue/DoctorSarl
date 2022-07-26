package com.doctorsarl.doctorsarl.services.interface_services;


import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;

import java.util.List;

public interface AffectationService {

    com.doctorsarl.doctorsarl.entities.AffectationService saveAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff);
    com.doctorsarl.doctorsarl.entities.AffectationService updateAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff);
    void deleteAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff);
    void deleteById(int id);
    com.doctorsarl.doctorsarl.entities.AffectationService getAffectation(int id);
    List<com.doctorsarl.doctorsarl.entities.AffectationService> getAllAffectation();
    List<com.doctorsarl.doctorsarl.entities.AffectationService> getAllAffectationActive();
    List<com.doctorsarl.doctorsarl.entities.AffectationService> getAllAffectationsByDossier(Dossier dossier);
    List<com.doctorsarl.doctorsarl.entities.AffectationService> getAllAffectationsByPersonnel(PersonnelMedical personnelMedical);
    void setDossierByAffectation(Dossier dossier);
}
