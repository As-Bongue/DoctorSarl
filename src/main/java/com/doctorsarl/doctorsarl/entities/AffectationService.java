package com.doctorsarl.doctorsarl.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "affectation_services")
public class AffectationService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_debut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_fin;

    private String etat;

    private String commentaire;

    @ManyToOne
    private Dossier dossier;

    @ManyToOne
    private Service service;

    @ManyToOne
    private PersonnelMedical personnelMedical;


    public AffectationService() {
    }

    public AffectationService(Date date_debut, Date date_fin, String etat, String commentaire, Dossier dossier, Service service, PersonnelMedical personnelMedical) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat = etat;
        this.commentaire = commentaire;
        this.dossier = dossier;
        this.service = service;
        this.personnelMedical = personnelMedical;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public PersonnelMedical getPersonnelMedical() {
        return personnelMedical;
    }

    public void setPersonnelMedical(PersonnelMedical personnelMedical) {
        this.personnelMedical = personnelMedical;
    }

    @Override
    public String toString() {
        return "AffectationService{" +
                "id=" + id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", etat='" + etat + '\'' +
                ", commentaire='" + commentaire + '\'' +
                ", dossier=" + dossier +
                ", service=" + service +
                ", personnelMedical=" + personnelMedical +
                '}';
    }
}
