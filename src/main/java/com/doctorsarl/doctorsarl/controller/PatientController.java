package com.doctorsarl.doctorsarl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {


    @RequestMapping("/patient_create")
    public String showCreatePatient(){
        return "patient/create_form";
    }
}
