package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.entities.Personne;
import com.doctorsarl.doctorsarl.repository.PersonneRepository;
import com.doctorsarl.doctorsarl.services.interface_services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;


    @Override
    public Personne savePersonne(Personne p) {
        return personneRepository.save(p);
    }

    @Override
    public Personne updatePersonne(Personne p) {
        return personneRepository.save(p);
    }

    @Override
    public void deletePersonne(Personne p) {
        personneRepository.delete(p);
    }

    @Override
    public void deleteById(int id) {
        personneRepository.deleteById(id);
    }

    @Override
    public Personne getPersonne(int id) {
        return personneRepository.findById(id).get();
    }

    @Override
    public List<Personne> getAllPersonne() {
        return personneRepository.findAll();
    }

}
