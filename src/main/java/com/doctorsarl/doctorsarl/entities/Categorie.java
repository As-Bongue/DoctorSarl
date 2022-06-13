package com.doctorsarl.doctorsarl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true, length = 15)
    private String code;
    @Column(nullable = false, unique = true)
    private String nom;

    @OneToMany(mappedBy = "categorie")
    private Collection<Service> services;

    public Categorie() {
    }

    public Categorie(String code, String nom, Collection<Service> services) {
        this.code = code;
        this.nom = nom;
        this.services = services;
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

    public Collection<Service> getServices() {
        return services;
    }

    public void setServices(Collection<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                ", code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", services=" + services +
                '}';
    }

}

