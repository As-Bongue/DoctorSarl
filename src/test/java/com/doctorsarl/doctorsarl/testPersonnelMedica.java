package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.repository.PersonnelMedicalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testPersonnelMedica {

    @Autowired
    private PersonnelMedicalRepository personnelMedicalRepository;

    @Test
    public void testCreatePersonnel(){
        PersonnelMedical p = new PersonnelMedical("bongue as", "as", "yassa", "65825486254", "bonguea25@gmail.com","", "dentiste", "douala", false);
        personnelMedicalRepository.save(p);
    }
}
