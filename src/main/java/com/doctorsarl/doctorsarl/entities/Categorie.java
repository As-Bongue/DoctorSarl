package com.doctorsarl.doctorsarl.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true, length = 15)
    private String code;
    @Column(nullable = false, unique = true)
    private String nom;

    public Categorie() {
    }

    public Categorie(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
