package com.doctorsarl.doctorsarl.services.interface_services;

import com.doctorsarl.doctorsarl.entities.Personne;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;

import java.util.List;

public interface PersonnelMedicalService {

    PersonnelMedical savePersonnelMedical(PersonnelMedical p);
    PersonnelMedical updatePersonnelMedical(PersonnelMedical p);
    void deletePersonnelMedical(PersonnelMedical p);
    void deletePersonnelById(int id);
    PersonnelMedical getPersonnelMedical(int id);
    List<PersonnelMedical> getAllPersonnelMedical();
    List<PersonnelMedical> getAllPersonnelMedicalByDisponibilite();
    void updateDisponibilitePersonnel(int id);
}
