package com.doctorsarl.doctorsarl.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dossiers")
public class Dossier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 15)
    private String code;
    @Column(nullable = false)
    private String note;
    private  boolean statut;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_creation;

    @ManyToOne
    private Patient patient;

    @OneToMany
    private List<AffectationService> affectationService;

    public Dossier() {
    }

    public Dossier(String code, String note, boolean statut, Date date_creation, Patient patient, List<AffectationService> affectationService) {

        this.code = code;
        this.note = note;
        this.statut = statut;
        this.date_creation = date_creation;
        this.patient = patient;
        this.affectationService = affectationService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<AffectationService> getAffectationService() {
        return affectationService;
    }

    public void setAffectationService(List<AffectationService> affectationService) {
        this.affectationService = affectationService;
    }

    @Override
    public String toString() {
        return "Dossier{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", note='" + note + '\'' +
                ", statut=" + statut +
                ", date_creation=" + date_creation +
                '}';
    }


}
