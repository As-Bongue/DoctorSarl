package com.doctorsarl.doctorsarl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    private Date date_creation;

    @ManyToOne
    private Patient patient;

    public Dossier() {
    }

    public Dossier(String code, String note, Date date_creation, Patient patient) {
        this.code = code;
        this.note = note;
        this.statut = true;
        this.date_creation = date_creation;
        this.patient = patient;
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

    @Override
    public String toString() {
        return "Dossier{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", note='" + note + '\'' +
                ", statut=" + statut +
                ", date_creation=" + date_creation +
                ", patient=" + patient +
                '}';
    }
}
