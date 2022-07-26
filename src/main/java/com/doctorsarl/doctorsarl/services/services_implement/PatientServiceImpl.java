package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.entities.Patient;
import com.doctorsarl.doctorsarl.repository.PatientRepository;
import com.doctorsarl.doctorsarl.services.interface_services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Patient updatePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public void deletePatient(Patient p) {
        patientRepository.delete(p);
    }

    @Override
    public void deleteById(int id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient getPatient(int id) {
        return (Patient) patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }


}
