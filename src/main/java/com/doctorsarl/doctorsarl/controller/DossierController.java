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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/dossier_opened")
    public String showAllOpenedDossiers(Model model){
        List<Dossier> dossiers = dossierService.getAllDossierOuvert();
        model.addAttribute("dossiers", dossiers);
        return "dossier/opened";
    }

    @GetMapping("/dossier_closed")
    public String showAllClosededDossiers(Model model){
        List<Dossier> dossiers = dossierService.getAllDossierFermer();
        model.addAttribute("dossiers", dossiers);
        return "dossier/closed";
    }

    @RequestMapping("/dossier_create/{id}")
    public String showCreateDossierForm(@PathVariable(value = "id") int id, Model model){
        Patient patient = patientService.getPatient(id);
//        List<Patient> patients = patientService.getAllPatient();
        model.addAttribute("dossier", new Dossier());
        model.addAttribute("patient", patient);
        return "dossier/create_form";
    }

    @PostMapping("/dossier_create")
    public String ceateDossier(Dossier dossier, RedirectAttributes r){
        dossierService.saveDossier(dossier);
        int id = dossier.getId();
        r.addFlashAttribute("message", "blaaaaaaaa");
        return "redirect:/dossier_show/" +id;
    }

    @GetMapping("/dossier_edit/{id}")
    public String showEditDossiersForm(@PathVariable("id") int id, Model model){
        Dossier dossier = dossierService.getDossier(id);
        Patient patient = dossier.getPatient();
        model.addAttribute("dossier", dossier);
        model.addAttribute("patient", patient);
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
