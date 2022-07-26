package com.doctorsarl.doctorsarl.controller.UserController;

import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.services.interface_services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class DashboardControllerUser {

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

    @Autowired
    private PatientService patientService;

    @GetMapping("/dashuser")
    public String showDashboard(Model model){
        int perso, pat, doss, aff, serv, perso_dispo, doss_ouvert, aff_cour, doss_ferme ;

        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedical();
//        perso = personnelMedicals.size();
        List<PersonnelMedical> p = personnelMedicalService.getAllPersonnelMedicalByDisponibilite();
        perso_dispo = p.size();

//        pat = patientService.getAllPatient().size();

        aff_cour = affectationService.getAllAffectationActive().size();

//        doss = dossierService.getAllDossier().size();
        doss_ouvert = dossierService.getAllDossierOuvert().size();
        doss_ferme = dossierService.getAllDossierFermer().size();

//        aff = affectationService.getAllAffectation().size();

//        serv = serviceService.getAllServices().size();

        model.addAttribute("personnels", personnelMedicals);
//        model.addAttribute("aff", aff);
//        model.addAttribute("serv", serv);
//        model.addAttribute("doss", doss);
//        model.addAttribute("perso", perso);
        model.addAttribute("perso_dispo", perso_dispo);
//        model.addAttribute("pat", pat);
        model.addAttribute("aff_cour", aff_cour);
        model.addAttribute("doss_ouvert", doss_ouvert);
        model.addAttribute("doss_ferme", doss_ferme);

        return "utilisateur/index";
    }
}
