package com.doctorsarl.doctorsarl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DossierController {


    @RequestMapping("/dossier_create")
    public String showCreateDossier(){
        return "dossier/create_form";
    }
}
