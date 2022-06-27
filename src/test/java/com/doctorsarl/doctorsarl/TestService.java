package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Categorie;
import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.CategorieRepository;
import com.doctorsarl.doctorsarl.repository.PersonnelMedicalRepository;
import com.doctorsarl.doctorsarl.repository.ServiceRepository;
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
public class TestService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private PersonnelMedicalRepository personnelMedicalRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateService(){

        Categorie c = categorieRepository.findById(1).get();

        PersonnelMedical p = personnelMedicalRepository.findById(1).get();

        Service serv = serviceRepository.save(new Service("001", "maternito", 2500, p, c));

        assertThat(serv.getId()).isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void ShowAllServices(){
        List<Service> services = serviceRepository.findAll();

        assertThat(services).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void showService(){
        Service s = serviceRepository.findById(1).get();

        assertThat(s.getNom()).isEqualTo("garde");
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void updateService(){
        Service s = serviceRepository.findById(1).get();
        s.setNom("marternite");

        assertThat(s.getNom()).isEqualTo("maternite");
    }

    @Test
    @Rollback(false)
    @Order(5)
    public void ShowAllDossier(){
        Service s = serviceRepository.findById(1).get();
        List<Dossier> dossiers = s.getDossiers();

        assertThat(dossiers).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(6)
    public void deleteService(){
        Service s = serviceRepository.findById(1).get();
        serviceRepository.deleteById(s.getId());

        Service s0 = serviceRepository.findById(1).get();
        assertThat(s0).isNull();
    }

}
