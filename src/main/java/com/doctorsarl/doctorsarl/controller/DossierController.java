package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.AffectationService;
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

import java.util.List;

@Controller
public class DossierController {

    @Autowired
    private DossierService dossierService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private com.doctorsarl.doctorsarl.services.interface_services.AffectationService affectationService;

    @GetMapping("/dossiers")
    public String showAllDossiers(Model model){
        List<Dossier> dossiers = dossierService.getAllDossier();
        model.addAttribute("dossiers", dossiers);
        return "dossier/show_all";
    }

    @RequestMapping("/dossier_create")
    public String showCreateDossierForm(Model model){
        List<Patient> patients = patientService.getAllPatient();
        model.addAttribute("dossier", new Dossier());
        model.addAttribute("patients", patients);
        return "dossier/create_form";
    }

    @PostMapping("/dossier_create")
    public String ceateDossier(Dossier dossier){
        dossierService.saveDossier(dossier);
        return "redirect:/dossiers";
    }

    @GetMapping("/dossier_edit/{id}")
    public String showEditDossiersForm(@PathVariable("id") int id, Model model){
        Dossier dossier = dossierService.getDossier(id);
        List<Patient> patients = patientService.getAllPatient();
        model.addAttribute("dossier", dossier);
        model.addAttribute("patients", patients);
        return "dossier/create_form";
    }

    @GetMapping("/dossier_show/{id}")
    public String showDossierDetail(@PathVariable("id") int id, Model model){
        Dossier dossier = dossierService.getDossier(id);
        List<AffectationService> affectationServiceLists = affectationService.getAllAffectationsByDossier(dossier);
        model.addAttribute("dossier", dossier);
        model.addAttribute("affectationServiceLists", affectationServiceLists);
        return "dossier/show";
    }

    @GetMapping("/dossier_delete/{id}")
    public String deleteDossier(@PathVariable("id") int id){
        dossierService.deleteById(id);
        return "redirect:/dossiers";
    }
}
