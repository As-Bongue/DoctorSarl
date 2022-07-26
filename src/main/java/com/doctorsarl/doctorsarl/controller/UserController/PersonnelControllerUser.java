package com.doctorsarl.doctorsarl.controller.UserController;

import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.services.interface_services.AffectationService;
import com.doctorsarl.doctorsarl.services.interface_services.PersonnelMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class PersonnelControllerUser {

    @Autowired
    PersonnelMedicalService personnelMedicalService;

    @Autowired
    AffectationService affectationService;

    @GetMapping("/personnels")
    public String showAllPersonnelMedical( Model model){
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedical();
        model.addAttribute("personnels", personnelMedicals);
        return "utilisateur/personnel/show_all";
    }

}
