package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Categorie;
import com.doctorsarl.doctorsarl.entities.Personne;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.CategorieRepository;
import com.doctorsarl.doctorsarl.repository.PersonneRepository;
import com.doctorsarl.doctorsarl.repository.PersonnelMedicalRepository;
import com.doctorsarl.doctorsarl.repository.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    PersonnelMedicalRepository personnelMedicalRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Test
    public void testCreateService(){

        Categorie c = categorieRepository.findById(1).get();

        PersonnelMedical p = personnelMedicalRepository.findById(1).get();

        Service serv = new Service("0045", "garde", 2500, p, c);
        serviceRepository.save(serv);
    }

}
