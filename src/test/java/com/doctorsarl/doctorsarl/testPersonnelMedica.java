package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.PersonnelMedicalRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class testPersonnelMedica {

    @Autowired
    private PersonnelMedicalRepository personnelMedicalRepository;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreatePersonnel(){
        PersonnelMedical p = new PersonnelMedical("bongue", "as", "yassa", "652586254", "bonguea25@gmail.com","", "dentiste", "douala");
        personnelMedicalRepository.save(p);
        assertThat(p.getId()).isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void showAllPersonnel(){
        List<PersonnelMedical> personnelMedicals = personnelMedicalRepository.findAll();

        assertThat(personnelMedicals).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void showPersonnel(){
        PersonnelMedical p = personnelMedicalRepository.findById(1).get();

        assertThat(p.getNom()).isEqualTo("bongue");
    }

    @Test
    @Rollback(false)
    @Order(4)
    public  void UpdatePersonnel(){
        PersonnelMedical p = personnelMedicalRepository.findById(1).get();
        p.setDisponibilite(true);

        assertThat(p.isDisponibilite()).isEqualTo(true);
    }

    @Test
    @Rollback(false)
    @Order(5)
    public void showAllPersonnelServices(){
        PersonnelMedical p = personnelMedicalRepository.findById(1).get();
        List<Service> services = p.getServices();

        assertThat(services).size().isGreaterThan(0);
    }

    @Test
    @Rollback
    @Order(6)
    public void deletePersonnel(){
        PersonnelMedical p = personnelMedicalRepository.findById(1).get();
        personnelMedicalRepository.deleteById(p.getId());

        PersonnelMedical p0 = personnelMedicalRepository.findById(1).get();
        assertThat(p0).isNull();
    }
}
