package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.DossierRepository;
import com.doctorsarl.doctorsarl.repository.ServiceRepository;
import com.doctorsarl.doctorsarl.services.interface_services.AffectationService;
import com.doctorsarl.doctorsarl.services.interface_services.PersonnelMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AffectationController {

    @Autowired
    private AffectationService affectationService;

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private ServiceRepository serviceRepository;

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

    @GetMapping("/affectation_create")
    public  String showAffectationForm(Model model){
        List<Service> services = serviceRepository.findAll();
        List<Dossier> dossiers = dossierRepository.findAll();
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedicalByDisponibilite();

        model.addAttribute("affectation", new com.doctorsarl.doctorsarl.entities.AffectationService());
        model.addAttribute("services", services);
        model.addAttribute("dossiers", dossiers);
        model.addAttribute("personnels", personnelMedicals);
        return "affectations/create_form";
    }

    @PostMapping("/affectation_create")
    public String createAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff){
        affectationService.saveAffectation(aff);
        return "redirect:/affectations";
    }

    @GetMapping("/affectation_edit/{id}")
    public String showEditAffectationForm(@PathVariable(value = "id") int id, Model model){
        com.doctorsarl.doctorsarl.entities.AffectationService aff = affectationService.getAffectation(id);
        List<Service> services = serviceRepository.findAll();
        List<Dossier> dossiers = dossierRepository.findAll();
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedical();
        model.addAttribute("affectation", aff);
        model.addAttribute("services", services);
        model.addAttribute("dossiers", dossiers);
        model.addAttribute("personnels", personnelMedicals);
        return "affectations/create_form";
    }

    @GetMapping("/affectation_delete/{id}")
    public String deleteAffectation(@PathVariable(value = "id") int id){
        affectationService.deleteById(id);
        return "redirect:/affectations";
    }
}
