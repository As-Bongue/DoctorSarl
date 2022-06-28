package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.Patient;
import com.doctorsarl.doctorsarl.services.interface_services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public String showAllPatient(Model model){
        List<Patient> patients = patientService.getAllPatient();
        model.addAttribute("patients", patients);
        return "patient/show_all";
    }

    @RequestMapping("/patient_create")
    public String showCreatePatientForm(Model model){
        model.addAttribute("patient", new Patient());
        return "patient/create_form";
    }

    @PostMapping("/patient_create")
    public String createPatient(Patient patient){
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patient_edit/{id}")
    public String showUpdatePatientForm(@PathVariable("id") int id, Model model){
        Patient patient = patientService.getPatient(id);
        model.addAttribute("patient", patient);
        return "patient/create_form";
    }

    @GetMapping("/patient_delete/{id}")
    public String deletePatient(@PathVariable("id") int id){
        patientService.deleteById(id);
        return "redirect:/patients";
    }
}
