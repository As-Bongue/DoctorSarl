package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.Patient;
import com.doctorsarl.doctorsarl.repository.PatientRepository;
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
public class TestPatient {

    @Autowired
    PatientRepository patientRepository;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreatePatient(){
        Patient p = new Patient("as", "bbbbb", "casa", "6554875552", "tem45j@gmail.com", "", 15, 'f');
        patientRepository.save(p);
        assertThat(p.getId()).isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(2)
    public  void showAllPatient(){
        List<Patient> patients = patientRepository.findAll();

        for (Patient patient: patients){
            System.out.println(patient);
        }

        assertThat(patients).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public  void showPatien(){
        Patient p = patientRepository.findById(1).get();

        assertThat(p.getId()).isEqualTo(1);
    }

    @Test
    @Rollback(false)
    @Order(4)
    public  void updatePatient(){
        Patient p = patientRepository.findById(2).get();
        p.setNom("astrin");

        assertThat(p.getNom()).isEqualTo("astrin");
    }

    @Test
    @Rollback(false)
    @Order(5)
    public void showAllPatientDossier(){
        Patient p = patientRepository.findById(1).get();
        List<Dossier> dossiers = p.getDossiers();

        assertThat(dossiers).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(6)
    public void deletePatient(){
        Patient p = patientRepository.findById(1).get();
        patientRepository.deleteById(p.getId());

        Patient p0 = patientRepository.findById(1).get();
        assertThat(p).isNull();
    }
}
