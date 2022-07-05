package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.repository.AffectationRepository;
import com.doctorsarl.doctorsarl.services.interface_services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AffectationServiceImpl implements AffectationService {

    @Autowired
    private AffectationRepository affectationRepository;

    @Override
    public com.doctorsarl.doctorsarl.entities.AffectationService saveAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff) {
        return affectationRepository.save(aff);
    }

    @Override
    public com.doctorsarl.doctorsarl.entities.AffectationService updateAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff) {
        return affectationRepository.save(aff);
    }

    @Override
    public void deleteAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff) {
        affectationRepository.delete(aff);
    }

    @Override
    public void deleteById(int id) {
        affectationRepository.deleteById(id);
    }

    @Override
    public com.doctorsarl.doctorsarl.entities.AffectationService getAffectation(int id) {
        return affectationRepository.findById(id).get();
    }

    @Override
    public List<com.doctorsarl.doctorsarl.entities.AffectationService> getAllAffectation() {
        return affectationRepository.findAll();
    }

    @Override
    public List<com.doctorsarl.doctorsarl.entities.AffectationService> getAllAffectationsByDossier(Dossier dossier) {
        List<com.doctorsarl.doctorsarl.entities.AffectationService> result = new ArrayList<>();
        List<com.doctorsarl.doctorsarl.entities.AffectationService> AllMyaffectations = affectationRepository.findAll();
        for (com.doctorsarl.doctorsarl.entities.AffectationService affectation:AllMyaffectations
        ) {
            if (affectation.getDossier().equals(dossier))
                result.add(affectation);
        }
        return result;

    }

    @Override
    public List<com.doctorsarl.doctorsarl.entities.AffectationService> getAllAffectationsByPersonnel(PersonnelMedical personnelMedical) {
        List<com.doctorsarl.doctorsarl.entities.AffectationService> result = new ArrayList<>();
        List<com.doctorsarl.doctorsarl.entities.AffectationService> AllMyaffectations = affectationRepository.findAll();
        for (com.doctorsarl.doctorsarl.entities.AffectationService affectation:AllMyaffectations
             ) {
            if (affectation.getPersonnelMedical().equals(personnelMedical))
                result.add(affectation);
        }
        return result;
    }


}
