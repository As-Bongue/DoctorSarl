package com.doctorsarl.doctorsarl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "services")
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 55)
    private String code_service;
    @Column(unique = true, nullable = false)
    private  String nom;
    @Column(nullable = false)
    private double prix;

    @ManyToOne
    private PersonnelMedical personne;
    @ManyToOne
    private Categorie categorie;

    public Service() {
    }

    public Service(String code_service, String nom, double prix, PersonnelMedical personne, Categorie categorie) {
        this.code_service = code_service;
        this.nom = nom;
        this.prix = prix;
        this.personne = personne;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode_service() {
        return code_service;
    }

    public void setCode_service(String code_service) {
        this.code_service = code_service;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public PersonnelMedical getPersonne() {
        return personne;
    }

    public void setPersonne(PersonnelMedical personne) {
        this.personne = personne;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", code_service='" + code_service + '\'' +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", personne=" + personne +
                ", categorie=" + categorie +
                '}';
    }
}
