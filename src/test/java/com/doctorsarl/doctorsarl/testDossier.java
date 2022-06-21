package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.Patient;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.DossierRepository;
import com.doctorsarl.doctorsarl.repository.PatientRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class testDossier {

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    PatientRepository patientRepository;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateDossier(){

        Patient p = patientRepository.findById(1).get();

        Dossier d   = dossierRepository.save(new Dossier("003","jhgjygyj", true, new Date(), p));
        assertThat(d.getCode()).isEqualTo("003");
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void showAllDossier(){
        List<Dossier> dossiers = dossierRepository.findAll();

        assertThat(dossiers).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void ShowDossier(){
        Dossier d = dossierRepository.findById(1).get();

        assertThat(d.getCode()).isEqualTo("001");
    }

    @Test
    @Rollback(false)
    @Order(4)
    public  void updateDossier(){
        Dossier d = dossierRepository.findById(1).get();
        d.setCode("005");

        assertThat(d.getCode()).isEqualTo("005");
    }

    @Test
    @Rollback(false)
    @Order(5)
    public void showAllDossierService(){
        Dossier d = dossierRepository.findById(1).get();
        List<Service> services = d.getServices();

        assertThat(services).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(6)
    public void deleteDossier(){
        Dossier d = dossierRepository.findById(1).get();
        dossierRepository.deleteById(d.getId());

        Dossier d0 = dossierRepository.findById(1).get();
        assertThat(d0).isNull();
    }
}
