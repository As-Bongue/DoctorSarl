package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.repository.PersonneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testPersonnelMedica {

    @Autowired
    PersonneRepository personneRepository;

    @Test
    public void testCreatePersonne(){
        PersonnelMedical p = new PersonnelMedical(
                "as", "bongue", "yassa", "653987653", "bonguea2@gmail.com", "chirugien", "douala",true
        );
        personneRepository.save(p);
    }
}
