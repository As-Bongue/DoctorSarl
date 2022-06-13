package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.repository.DossierRepository;
import com.doctorsarl.doctorsarl.services.interface_services.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierServiceImpl implements DossierService {

    @Autowired
    DossierRepository dossierRepository;

    @Override
    public Dossier saveDossier(Dossier d) {
        return dossierRepository.save(d);
    }

    @Override
    public Dossier updateDossier(Dossier d) {
        return dossierRepository.save(d);
    }

    @Override
    public void deleteDossier(Dossier d) {
        dossierRepository.delete(d);
    }

    @Override
    public void deleteById(int id) {
        dossierRepository.deleteById(id);
    }

    @Override
    public Dossier getDossier(int id) {
        return dossierRepository.findById(id).get();
    }

    @Override
    public List<Dossier> getAllDossier() {
        return dossierRepository.findAll();
    }
}
