package com.doctorsarl.doctorsarl.repository;

import com.doctorsarl.doctorsarl.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args){

////        creer des utilisateurs
//        Personne p1 = new Personne("admin", "", "", "524", "admin@gmail.com", passwordEncoder.encode("00000000"), "ADMIN", "P1,P2,P3");
//        Personne p2 = new Personne("user", "", "","38", "user@gmail.com", passwordEncoder.encode("11111111"), "USER", "P1,P2");
//        Personne p3 = new Personne("personnel", "", "", "759", "personnel@gmail.com", passwordEncoder.encode("22222222"), "PERSONNEL", "P1");
//
//        List<Personne> p = Arrays.asList(p1, p2, p3);
//
//        personneRepository.saveAll(p);
    }
}
