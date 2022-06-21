package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Categorie;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.CategorieRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestCategorie {

    @Autowired
    CategorieRepository categorieRepository;

    @Test
    @Rollback(false)
    @Order(2)
    public void showAllCategories(){
        List<Categorie> categories = categorieRepository.findAll();

        assertThat(categories).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void testFindCategorie(){
        Categorie c = categorieRepository.findById(1).get();

        assertThat(c.getCode()).isEqualTo("005");
    }

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateCategorie(){
        Categorie c = new Categorie("0012", "operation");
        categorieRepository.save(c);

        assertThat(c.getId()).isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void testUpdateCategorie(){
        Categorie c = categorieRepository.findById(1).get();
        c.setCode("005");
        categorieRepository.save(c);

        Categorie c0 = categorieRepository.findById(1).get();
        assertThat(c0.getCode()).isEqualTo("005");
    }

    public void showAllCategorieService(){
        Categorie c = categorieRepository.findById(1).get();
        List<Service> services = c.getServices();

        assertThat(services).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void testDeleteCategorie(){
        Categorie c = categorieRepository.findById(1).get();
        categorieRepository.deleteById(c.getId());

        Categorie c0 = categorieRepository.findById(1).get();
        assertThat(c0).isNull();
    }
}
