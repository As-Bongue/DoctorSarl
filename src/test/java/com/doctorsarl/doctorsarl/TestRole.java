package com.doctorsarl.doctorsarl;

import com.doctorsarl.doctorsarl.entities.Personne;
import com.doctorsarl.doctorsarl.entities.Role;
import com.doctorsarl.doctorsarl.repository.PersonneRepository;
import com.doctorsarl.doctorsarl.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TestRole {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PersonneRepository personneRepository;

    @Test
    void createRole(){
        Role user = new Role("User");
        Role admin = new Role("Admin");
        Role customer = new Role("Customer");

        roleRepository.save(user);
        roleRepository.save(admin);
        roleRepository.save(customer);

        List<Role> listRoles = roleRepository.findAll();

        assertThat(listRoles.size()).isGreaterThan(3);
    }

    @Test
    void addRoleToUser(){
        Role roleAdmin = roleRepository.findById(4).get();
        Personne personne = personneRepository.findById(1).get();

        personne.addRole(roleAdmin);

        Personne personne1 = personneRepository.save(personne);
        assertThat(personne1.getRoles()).size().isEqualTo(2);
    }
}
