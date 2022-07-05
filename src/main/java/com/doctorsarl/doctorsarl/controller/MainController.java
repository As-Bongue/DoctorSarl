package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.Personne;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.services.interface_services.PersonneService;
import com.doctorsarl.doctorsarl.services.interface_services.PersonnelMedicalService;
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
    PersonnelMedicalService personnelMedicalService;

    @GetMapping("/")
    public String showHomePge() {
        return "index";
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
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedical();
        model.addAttribute("personnels", personnelMedicals);
        return "admin/index";
    }

}

