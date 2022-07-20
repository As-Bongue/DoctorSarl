package com.doctorsarl.doctorsarl.services.interface_services;

import com.doctorsarl.doctorsarl.entities.Personne;

import java.util.List;

public interface PersonneService {

    Personne savePersonne(Personne p);
    Personne updatePersonne(Personne p);
    void deletePersonne(Personne p);
    void deleteById(int id);
    Personne getPersonne(int id);
    List<Personne> getAllPersonne();
    void rgistedDefaultPersonne(Personne p);
}
