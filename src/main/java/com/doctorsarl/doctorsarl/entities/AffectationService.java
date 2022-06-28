package com.doctorsarl.doctorsarl.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "affectation_services")
public class AffectationService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;

    @ManyToOne
    private Dossier dossier;

    @ManyToOne
    private Service service;

    public AffectationService() {
    }

    public AffectationService(Date date, Dossier dossier, Service service) {
        this.date = date;
        this.dossier = dossier;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "AffectationService{" +
                "id=" + id +
                ", date=" + date +
                ", dossier=" + dossier +
                ", service=" + service +
                '}';
    }
}
