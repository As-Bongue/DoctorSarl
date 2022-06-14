package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Categorie;
import com.doctorsarl.doctorsarl.repository.CategorieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCategorie {

    @Autowired
    CategorieRepository categorieRepository;

    @Test
    public void testCreateCategorie(){
        Categorie c = new Categorie("0045", "chirugie");
        categorieRepository.save(c);
    }
}
