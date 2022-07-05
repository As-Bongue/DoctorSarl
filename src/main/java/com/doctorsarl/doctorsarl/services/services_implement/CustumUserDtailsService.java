package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.entities.Personne;
import com.doctorsarl.doctorsarl.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustumUserDtailsService implements UserDetailsService {

    @Autowired
    PersonneRepository personneRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Personne personne = personneRepository.findByEmail(email);
        if (personne == null){
            throw new UsernameNotFoundException("Utilisateur non existant");
        }
        return new com.doctorsarl.doctorsarl.services.services_implement.UserDetails(personne);
    }
}
