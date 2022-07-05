package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.AffectationService;
import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.AffectationRepository;
import com.doctorsarl.doctorsarl.repository.DossierRepository;
import com.doctorsarl.doctorsarl.repository.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TestAffectations {

    @Autowired
    private AffectationRepository affectationRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private DossierRepository dossierRepository;

//    @Test
//    public void testCreateAffection(){
//        Dossier d = dossierRepository.findById(1).get();
//        Service s = serviceRepository.findById(5).get();
//
//        AffectationService aff = new AffectationService("2002-05-10", d, s);
//        affectationRepository.save(aff);
//
//        assertThat(aff.getId()).isGreaterThan(0);
//    }
}
