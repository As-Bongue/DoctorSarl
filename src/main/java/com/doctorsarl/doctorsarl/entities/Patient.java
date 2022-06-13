package com.doctorsarl.doctorsarl.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@DiscriminatorValue("patient") // indique le type dans la table users à chaque fois quion cree un patient
public class Patient extends Personne {

    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private char sexe;

    @OneToMany(mappedBy = "patient")
    private Collection<Dossier> dossiers;

    public Patient() {
    }

    public Patient(String nom, String prenom, String adresse, String telephone, String email, int age) {
        super(nom, prenom, adresse, telephone, email);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                ", sexe=" + sexe +
                '}';
    }
}
