package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Categorie;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.CategorieRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestCategories {

    @Autowired
    CategorieRepository categorieRepository;

    @Test
    @Rollback(false)
    @Order(2)
    public void showAllCategories(){
        List<Categorie> categories = categorieRepository.findAll();

        for (Categorie categorie: categories){
            System.out.println(categorie);
        }

        assertThat(categories).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void testFindCategories(){
        Categorie c = categorieRepository.findById(1).get();
        System.out.println(c.toString());

        assertThat(c.getCode()).isEqualTo("001");
    }

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateCategories(){
        Categorie c = new Categorie("002", "aaaaaaa");
        categorieRepository.save(c);

        assertThat(c.getId()).isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void testUpdateCategories(){
        Categorie c = categorieRepository.findById(1).get();
        c.setCode("005");
        categorieRepository.save(c);

        Categorie c0 = categorieRepository.findById(1).get();
        assertThat(c0.getCode()).isEqualTo("005");
    }

    @Test
    @Rollback(false)
    @Order(5)
    public void showAllCategoriesService(){
        Categorie c = categorieRepository.findById(1).get();
        List<Service> services = c.getServices();

        assertThat(services).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    @Order(6)
    public void testDeleteCategories(){
        Categorie c = categorieRepository.findById(5).get();
        categorieRepository.delete(c);

        Categorie c0 = categorieRepository.findById(5).get();
        assertThat(c0).isNull();
    }
}
