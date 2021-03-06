package com.doctorsarl.doctorsarl.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patients")
@DiscriminatorValue("patient") // indique le type dans la table users à chaque fois quion cree un patient
public class Patient extends Personne {

    private int age;

    private char sexe;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Dossier> dossiers;

    public Patient() {
    }

    public Patient(String nom, String prenom, String adresse, String telephone, String email, String password, int age, char sexe) {
        super(nom, prenom, adresse, telephone, email, password);
        this.age = age;
        this.sexe = sexe;
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

    public List<Dossier> getDossiers() {
        return dossiers;
    }

    public void setDossiers(List<Dossier> dossiers) {
        this.dossiers = dossiers;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                ", sexe=" + sexe +
                '}';
    }
}
