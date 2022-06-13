package com.doctorsarl.doctorsarl.entities;

public class Patient extends Personne {

    private int age;

    private char sexe;

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
