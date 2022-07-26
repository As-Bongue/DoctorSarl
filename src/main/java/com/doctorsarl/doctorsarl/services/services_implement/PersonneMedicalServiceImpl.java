package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.repository.PersonnelMedicalRepository;
import com.doctorsarl.doctorsarl.services.interface_services.PersonnelMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneMedicalServiceImpl implements PersonnelMedicalService {
    @Autowired
    PersonnelMedicalRepository personnelMedicalRepository;

    @Override
    public PersonnelMedical savePersonnelMedical(PersonnelMedical p) {
        return personnelMedicalRepository.save(p);
    }

    @Override
    public PersonnelMedical updatePersonnelMedical(PersonnelMedical p) {
        return personnelMedicalRepository.save(p);
    }

    @Override
    public void deletePersonnelMedical(PersonnelMedical p) {
        personnelMedicalRepository.delete(p);
    }

    @Override
    public void deletePersonnelById(int id) {
        personnelMedicalRepository.deleteById(id);
    }

    @Override
    public PersonnelMedical getPersonnelMedical(int id) {
        return (PersonnelMedical) personnelMedicalRepository.findById(id).get();
    }

    @Override
    public List<PersonnelMedical> getAllPersonnelMedical() {
        return personnelMedicalRepository.findAll();
    }

    @Override
    public List<PersonnelMedical> getAllPersonnelMedicalByDisponibilite() {
//        List<PersonnelMedical> personnelMedicals = new ArrayList<>();
//        List<PersonnelMedical> personnelMedicals1 = getAllPersonnelMedical();
//        personnelMedicals = personnelMedicals1.stream().
//                filter(personnelMedical -> personnelMedical.isDisponibilite()==true)
//                .collect(Collectors.toList());
//        for (PersonnelMedical personnel2:personnelMedicals1
//             ) {
//            if (personnel2.isDisponibilite())
//                personnelMedicals.add(personnel2);
//        }
        return getAllPersonnelMedical().stream().
                filter(PersonnelMedical::isDisponibilite)
                .collect(Collectors.toList());
    }

    @Override
    public void updateDisponibilitePersonnel(int id) {
        PersonnelMedical p = getPersonnelMedical(id);
        if (p.isDisponibilite())
            p.setDisponibilite(false);
        else
            p.setDisponibilite(true);
        personnelMedicalRepository.save(p);
    }

}
