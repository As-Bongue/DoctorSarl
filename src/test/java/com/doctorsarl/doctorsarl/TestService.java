package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Categorie;
import com.doctorsarl.doctorsarl.entities.Personne;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.CategorieRepository;
import com.doctorsarl.doctorsarl.repository.PersonneRepository;
import com.doctorsarl.doctorsarl.repository.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    PersonneRepository personneRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Test
    public void testCreateService(){

        PersonnelMedical p = new PersonnelMedical(
                "as", "bongue", "yassa", "653987653", "bonguea2@gmail.com", "chirugien", "douala",true
        );

        Categorie c = new Categorie("0001", "cat01");

        Service serv = new Service("0045", "garde", 2500, p, c);
        serviceRepository.save(serv);
    }
}
