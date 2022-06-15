package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Patient;
import com.doctorsarl.doctorsarl.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestPatient {

    @Autowired
    PatientRepository patientRepository;

    @Test
    public void testCreatePatient(){
        Patient p = new Patient("temj", "junior", "casa", "65875552", "temj@gmail.com", "", 15, 'm');
        patientRepository.save(p);
    }
}
