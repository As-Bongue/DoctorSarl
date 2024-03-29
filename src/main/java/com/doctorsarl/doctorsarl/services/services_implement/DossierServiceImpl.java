package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.Patient;
import com.doctorsarl.doctorsarl.repository.DossierRepository;
import com.doctorsarl.doctorsarl.services.interface_services.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
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

    @Override
    public List<Dossier> getAllDossierByPatient(Patient patient) {
        List<Dossier> dossiers = new ArrayList<>();
        List<Dossier> dossiers1 = dossierRepository.findAll();
        for (Dossier dossier: dossiers1
             ) {
            if (dossier.getPatient().equals(patient))
                dossiers.add(dossier);
        }
        return dossiers;
    }

    @Override
    public List<Dossier> getAllDossierOuvert() {
        return getAllDossier().stream()
                .filter(Dossier::isStatut)
                .collect(Collectors.toList());
    }

    @Override
    public List<Dossier> getAllDossierFermer() {

        return getAllDossier().stream()
                .filter(Dossier->!Dossier.isStatut())
                .collect(Collectors.toList());

//        List<Dossier> dossiers = new ArrayList<>();
//        List<Dossier> dossiers1 = getAllDossier();
//        for (Dossier dossier: dossiers1
//             ) {
//            if (!dossier.isStatut())
//                dossiers.add(dossier);
//        }
//        return dossiers;
    }


}
