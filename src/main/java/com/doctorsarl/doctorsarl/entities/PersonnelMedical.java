package com.doctorsarl.doctorsarl.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personnels")
@DiscriminatorValue("perso_medical") // indique le type dans la table users à chaque fois qu'on cree un personnel medical
public class PersonnelMedical extends Personne {

    private String profession;

    private String ville;

    private boolean disponibilite;

    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
    private List<Service> services;

    public PersonnelMedical() {
    }

    public PersonnelMedical(String nom, String prenom, String adresse, String telephone, String email, String password, String profession, String ville) {
        super(nom, prenom, adresse, telephone, email, password);
        this.profession = profession;
        this.ville = ville;
        this.disponibilite = true;
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "PersonnelMedical{" +
                "profession='" + profession + '\'' +
                ", ville='" + ville + '\'' +
                ", disponibilite=" + disponibilite +
                ", services=" + services +
                '}';
    }
}
