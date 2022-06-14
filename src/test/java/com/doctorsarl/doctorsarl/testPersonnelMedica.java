package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.repository.PersonneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testPersonnelMedica {

    @Autowired
    private PersonneRepository personneRepository;

    @Test
    public void testCreatePersonne(){
        PersonnelMedical p = new PersonnelMedical();
        p.setNom("bongue");
        p.setPrenom("as");
        p.setEmail("bonguea2@gmail.com");
        p.setAdresse("yassa");
        p.setProfession("dentiste");
        p.setTelephone("6582548624");
        p.setVille("douala");
        p.setDisponibilite(false);
        personneRepository.save(p);
    }
}
