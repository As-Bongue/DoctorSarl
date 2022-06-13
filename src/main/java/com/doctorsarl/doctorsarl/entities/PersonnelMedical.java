package com.doctorsarl.doctorsarl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class PersonnelMedical extends Personne {

    @Column(nullable = false)
    private String profession;
    @Column(nullable = false)
    private String ville;
    private boolean disponibilite;

    @OneToMany(mappedBy = "personne")
    private Collection<Service> services;

    public PersonnelMedical() {
    }

    public PersonnelMedical(String nom, String prenom, String adresse, String telephone, String email, String profession, String ville, boolean disponibilite) {
        super(nom, prenom, adresse, telephone, email);
        this.profession = profession;
        this.ville = ville;
        this.disponibilite = disponibilite;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Override
    public String toString() {
        return "PersonnelMedical{" +
                "profession='" + profession + '\'' +
                ", ville='" + ville + '\'' +
                ", disponibilite=" + disponibilite +
                '}';
    }
}
