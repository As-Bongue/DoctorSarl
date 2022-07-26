package com.doctorsarl.doctorsarl.controller.AdminController;

import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.Patient;
import com.doctorsarl.doctorsarl.services.interface_services.DossierService;
import com.doctorsarl.doctorsarl.services.interface_services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DossierService dossierService;

    @GetMapping("/patients")
    public String showAllPatient(Model model){
        List<Patient> patients = patientService.getAllPatient();
        model.addAttribute("patients", patients);
        return "admin/patient/show_all";
    }

    @RequestMapping("/patient_create")
    public String showCreatePatientForm(Model model){
        model.addAttribute("patient", new Patient());
        return "admin/patient/create_form";
    }

    @PostMapping("/patient_create")
    public String createPatient(Patient patient, RedirectAttributes r){
        patientService.savePatient(patient);
        int id = patient.getId();
        r.addFlashAttribute("message", "blaaaaaaaaa");
        return "redirect:/admin/patient_show/" +id;
    }

    @GetMapping("/patient_edit/{id}")
    public String showUpdatePatientForm(@PathVariable("id") int id, Model model){
        Patient patient = patientService.getPatient(id);
        model.addAttribute("patient", patient);
        return "admin/patient/create_form";
    }

    @GetMapping("/patient_show/{id}")
    public String showDetailsPatient(@PathVariable(value = "id") int id, Model model){
        Patient patient = patientService.getPatient(id);
        List<Dossier> dossiers = dossierService.getAllDossierByPatient(patient);
        model.addAttribute("patient", patient);
        model.addAttribute("dossiers", dossiers);
        return "admin/patient/show";
    }

    @GetMapping("/patient_delete/{id}")
    public String deletePatient(@PathVariable("id") int id){
        patientService.deleteById(id);
        return "redirect:/admin/patients";
    }
}
