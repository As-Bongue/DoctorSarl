package com.doctorsarl.doctorsarl.entities;

import java.io.Serializable;

public class Service implements Serializable {

    private String code_service;

    private  String nom;

    private double prix;

    public Service() {
    }

    public Service(String code_service, String nom, double prix) {
        this.code_service = code_service;
        this.nom = nom;
        this.prix = prix;
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

    @Override
    public String toString() {
        return "Service{" +
                "code_service='" + code_service + '\'' +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
