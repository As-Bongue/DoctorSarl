package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.DossierRepository;
import com.doctorsarl.doctorsarl.repository.ServiceRepository;
import com.doctorsarl.doctorsarl.services.interface_services.AffectationService;
import com.doctorsarl.doctorsarl.services.interface_services.DossierService;
import com.doctorsarl.doctorsarl.services.interface_services.PersonnelMedicalService;
import com.doctorsarl.doctorsarl.services.interface_services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AffectationController {

    @Autowired
    private AffectationService affectationService;

    @Autowired
    private DossierService dossierService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private PersonnelMedicalService personnelMedicalService;

    @GetMapping("/affectations")
    public  String showAllAffectatio(Model model){
        List<com.doctorsarl.doctorsarl.entities.AffectationService> affectations = affectationService.getAllAffectation();
        model.addAttribute("affectations", affectations);
        return "affectations/show_all";
    }

    @GetMapping("/affectation_show/{id}")
    public String showAffectationDetail(@PathVariable(value = "id") int id, Model model){
        com.doctorsarl.doctorsarl.entities.AffectationService affectation = affectationService.getAffectation(id);
        model.addAttribute("affectation", affectation);
        return "affectations/show";
    }

//    @GetMapping("/affectation_create")
//    public  String showAffectationForm(Model model){
//        List<Service> services = serviceRepository.findAll();
//        List<Dossier> dossiers = dossierRepository.findAll();
//        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedicalByDisponibilite();
//
//        model.addAttribute("affectation", new com.doctorsarl.doctorsarl.entities.AffectationService());
//        model.addAttribute("services", services);
//        model.addAttribute("dossiers", dossiers);
//        model.addAttribute("personnels", personnelMedicals);
//        return "affectations/create_form";
//    }

//    @PostMapping("/affectation_create")
//    public String createAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff, RedirectAttributes r){
//        com.doctorsarl.doctorsarl.entities.AffectationService a = affectationService.saveAffectation(aff);
//        PersonnelMedical p = a.getPersonnelMedical();
//        p.setDisponibilite(false);
//        personnelMedicalService.savePersonnelMedical(p);
//        r.addFlashAttribute("message", "blaaaaaaa");
//        return "redirect:/affectations";
//    }

    @GetMapping("/affectation_dossier/{id}")
    public  String showAffectationDosierForm(@PathVariable(value = "id") int id, Model model){
        List<Service> services = serviceService.getAllServices();
        Dossier dossier = dossierService.getDossier(id);
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedicalByDisponibilite();

        model.addAttribute("affectation", new com.doctorsarl.doctorsarl.entities.AffectationService());
        model.addAttribute("services", services);
        model.addAttribute("dossier", dossier);
        model.addAttribute("personnels", personnelMedicals);
        return "affectations/create_form";
    }

    @PostMapping("/affectation_dossier")
    public String createAffectationInDossier(com.doctorsarl.doctorsarl.entities.AffectationService aff, RedirectAttributes r){
//        Dossier dossier = dossierRepository.findById(id).get();
//        aff.setDossier(dossier);
        aff.setEtat("en attente");
        com.doctorsarl.doctorsarl.entities.AffectationService a = affectationService.saveAffectation(aff);

        PersonnelMedical p = a.getPersonnelMedical();
        p.setDisponibilite(false);
        personnelMedicalService.savePersonnelMedical(p);

        Dossier d = a.getDossier();
        d.setStatut(true);
        dossierService.saveDossier(d);

        r.addFlashAttribute("message", "blaaaaaaa");
        int id = aff.getDossier().getId();
        return "redirect:/dossier_show/" +id;
    }


    @GetMapping("/affectation_edit/{id}")
    public String showEditAffectationForm(@PathVariable(value = "id") int id, Model model){
        com.doctorsarl.doctorsarl.entities.AffectationService aff = affectationService.getAffectation(id);
        List<Service> services = serviceService.getAllServices();
        List<Dossier> dossiers = dossierService.getAllDossier();
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedical();
        model.addAttribute("affectation", aff);
        model.addAttribute("services", services);
        model.addAttribute("dossiers", dossiers);
        model.addAttribute("personnels", personnelMedicals);
        return "affectations/create_form";
    }

    @GetMapping("/affectation_cour/{id}")
    public String updateAffectationEtatCour(@PathVariable(value = "id") int id){
        com.doctorsarl.doctorsarl.entities.AffectationService aff = affectationService.getAffectation(id);
        aff.setEtat("en cour");
        affectationService.saveAffectation(aff);

        Dossier d = aff.getDossier();
        int idd = d.getId();

        affectationService.setDossierByAffectation(d);

        return "redirect:/dossier_show/" + idd;
    }

    @GetMapping("/affectation_termine/{id}")
    public String updateAffectationEtatFin(@PathVariable(value = "id") int id){
        com.doctorsarl.doctorsarl.entities.AffectationService aff = affectationService.getAffectation(id);
        aff.setEtat("terminé");
        affectationService.saveAffectation(aff);

        Dossier d = aff.getDossier();
        int idd = d.getId();

        affectationService.setDossierByAffectation(d);

        return "redirect:/dossier_show/" + idd;
    }


    @GetMapping("/affectation_delete/{id}")
    public String deleteAffectation(@PathVariable(value = "id") int id){
        affectationService.deleteById(id);
        return "redirect:/affectations";
    }
}
