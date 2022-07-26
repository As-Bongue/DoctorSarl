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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
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

//    @GetMapping("/login")
//    public String showLoginForm(){
//        return "login";
//    }

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

}

