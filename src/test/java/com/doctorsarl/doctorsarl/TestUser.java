package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Personne;
import com.doctorsarl.doctorsarl.repository.PersonneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TestUser {

    @Autowired
    private PersonneRepository personneRepository;

//    @Test
//    public void testCreatePersonne(){
//        Personne personne = new Personne("user 1", "user 1","yassa", "55555555", "user1@gmail.com", "00000");
//        Personne personne1 = personneRepository.save(personne);
//        Personne personne2 = personneRepository.findById(personne1.getId()).get();
//
//        assertThat(personne2.getEmail()).isEqualTo(personne.getEmail());
//    }

    @Test
    public void findPersonneByEmail(){
        String email = "user1@gmail.com";
        Personne personne = personneRepository.findByEmail(email);

        assertThat(personne).isNotNull();
    }
}
