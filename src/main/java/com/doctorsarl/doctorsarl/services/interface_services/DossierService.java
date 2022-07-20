package com.doctorsarl.doctorsarl.services.interface_services;

import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.Patient;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DossierService {

    Dossier saveDossier(Dossier d);
    Dossier updateDossier(Dossier d);
    void deleteDossier(Dossier d);
    void deleteById(int id);
    Dossier getDossier(int id);
    List<Dossier> getAllDossier();
    List<Dossier> getAllDossierByPatient(Patient patient);
    List<Dossier> getAllDossierOuvert();
    List<Dossier> getAllDossierFermer();
}
