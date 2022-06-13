package com.doctorsarl.doctorsarl.entities;

import java.io.Serializable;
import java.util.Date;

public class Dossier implements Serializable {

    private String code;

    private String note;

    private  boolean statut;

    private Date date_creation;

    public Dossier() {
    }

    public Dossier(String code, String note, boolean statut, Date date_creation) {
        this.code = code;
        this.note = note;
        this.statut = statut;
        this.date_creation = date_creation;
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

    @Override
    public String toString() {
        return "Dossier{" +
                "code='" + code + '\'' +
                ", note='" + note + '\'' +
                ", statut=" + statut +
                ", date_creation=" + date_creation +
                '}';
    }
}
