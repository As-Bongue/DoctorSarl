package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.Personne;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.services.interface_services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PersonneService personneService;

    @Autowired
    private PersonnelMedicalService personnelMedicalService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private DossierService dossierService;

    @Autowired
    private AffectationService affectationService;

    @GetMapping("/")
    public String showHomePge() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new Personne());
        return "signup_form";
    }

    @PostMapping("/register")
    public String saveUser(Personne personne){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoderPassword = encoder.encode(personne.getPassword());
        personne.setPassword(encoderPassword);
        personneService.savePersonne(personne);
        return "register_sucess";
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model){
        int perso, doss, aff, serv ;
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedical();
        perso = personnelMedicals.size();
        doss = dossierService.getAllDossier().size();
        aff = affectationService.getAllAffectation().size();
        serv = serviceService.getAllServices().size();
        model.addAttribute("personnels", personnelMedicals);
        model.addAttribute("aff", aff);
        model.addAttribute("serv", serv);
        model.addAttribute("doss", doss);
        model.addAttribute("perso", perso);
        return "admin/index";
    }

}

