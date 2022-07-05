package com.doctorsarl.doctorsarl.services.interface_services;

import com.doctorsarl.doctorsarl.entities.Patient;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient p);
    Patient updatePatient(Patient p);
    void deletePatient(Patient p);
    void deleteById( int id);
    Patient getPatient(int id);
    List<Patient> getAllPatient();

}
