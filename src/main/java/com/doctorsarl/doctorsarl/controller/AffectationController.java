package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.Dossier;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.repository.DossierRepository;
import com.doctorsarl.doctorsarl.repository.ServiceRepository;
import com.doctorsarl.doctorsarl.services.interface_services.AffectationService;
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

    @GetMapping("/affectations")
    public  String showAllAffectatio(Model model){
        List<com.doctorsarl.doctorsarl.entities.AffectationService> affectations = affectationService.getAllAffectation();
        model.addAttribute("affectations", affectations);
        return "affectations/show_all";
    }

    @GetMapping("/affectation_create")
    public  String showAffectationForm(Model model){
        List<Service> services = serviceRepository.findAll();
        List<Dossier> dossiers = dossierRepository.findAll();

        model.addAttribute("affectation", new com.doctorsarl.doctorsarl.entities.AffectationService());
        model.addAttribute("services", services);
        model.addAttribute("dossiers", dossiers);
        return "affectations/create_form";
    }

    @PostMapping("/affectation_create")
    public String createAffectation(com.doctorsarl.doctorsarl.entities.AffectationService aff){
        affectationService.saveAffectation(aff);
        return "redirect:/affectations";
    }

    @GetMapping("/affectation_edit/{id}")
    public String showEditAffectationForm(@PathVariable("id") int id, Model model){
        com.doctorsarl.doctorsarl.entities.AffectationService aff = affectationService.getAffectation(id);
        List<Service> services = serviceRepository.findAll();
        List<Dossier> dossiers = dossierRepository.findAll();
        model.addAttribute("affectation", aff);
        model.addAttribute("services", services);
        model.addAttribute("dossiers", dossiers);
        return "affectations/create_form";
    }

    @GetMapping("/affectation_delete/{id}")
    public String deleteAffectation(@PathVariable("id") int id){
        affectationService.deleteById(id);
        return "redirect:/affectation";
    }
}
