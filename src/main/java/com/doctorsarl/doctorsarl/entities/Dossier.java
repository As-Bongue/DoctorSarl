package com.doctorsarl.doctorsarl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Dossier implements Serializable {

    @Id
    @Column(unique = true, nullable = false, length = 15)
    private String code;
    @Column(nullable = false)
    private String note;
    private  boolean statut;
    @Column(nullable = false)
    private Date date_creation;

    @ManyToOne
    private Patient patient;

    @ManyToMany( mappedBy = "dossiers",fetch = FetchType.EAGER) //recupere un dossier avec tous ses services
    private Collection<Service> sevices;

    public Dossier() {
    }

    public Dossier(String code, String note, boolean statut, Date date_creation, Patient patient, Collection<Service> sevices) {
        this.code = code;
        this.note = note;
        this.statut = statut;
        this.date_creation = date_creation;
        this.patient = patient;
        this.sevices = sevices;
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

    public Collection<Service> getSevices() {
        return sevices;
    }

    public void setSevices(Collection<Service> sevices) {
        this.sevices = sevices;
    }

    @Override
    public String toString() {
        return "Dossier{" +
                "code='" + code + '\'' +
                ", note='" + note + '\'' +
                ", statut=" + statut +
                ", date_creation=" + date_creation +
                ", patient=" + patient +
                ", sevices=" + sevices +
                '}';
    }
}
