package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.repository.AffectationRepository;
import com.doctorsarl.doctorsarl.services.interface_services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
