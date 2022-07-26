package com.doctorsarl.doctorsarl.controller.AdminController;

import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.services.interface_services.AffectationService;
import com.doctorsarl.doctorsarl.services.interface_services.PersonnelMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class PersonnelController {

    @Autowired
    PersonnelMedicalService personnelMedicalService;

    @Autowired
    AffectationService affectationService;

    @GetMapping("/personnels")
    public String showAllPersonnelMedical( Model model){
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedical();
        model.addAttribute("personnels", personnelMedicals);
        return "admin/personnel/show_all";
    }

    @GetMapping("/personnel_create")
    public String showCreatePersonnelForm(Model model){
        model.addAttribute("personnel", new PersonnelMedical());
        return "admin/personnel/create_form";
    }

    @PostMapping("/personnel_create")
    public String createPersonnel(PersonnelMedical personnelMedical, RedirectAttributes ra){
        personnelMedical.setDisponibilite(true);
        personnelMedicalService.savePersonnelMedical(personnelMedical);
        ra.addFlashAttribute("message", "personnel enregistrer avec sucess");
        return "redirect:/admin/personnels";
    }

    @GetMapping("/personnel_edit/{id}")
    public String showEditPersonnelForm(@PathVariable("id") int id, Model model){
        PersonnelMedical personnelMedical = personnelMedicalService.getPersonnelMedical(id);
        model.addAttribute("personnel", personnelMedical);
        return "admin/personnel/create_form";
    }

    @GetMapping("/personnel_disponibilite/{id}")
    public String updateDisponibilite(@PathVariable("id") int id){
        personnelMedicalService.updateDisponibilitePersonnel(id);
        return "redirect:/admin/personnels";
    }

    @GetMapping("/personnel_detail/{id}")
    public String ShowPersonnelMedicalDetails(@PathVariable("id") int id, Model model){
        PersonnelMedical personnelMedical = personnelMedicalService.getPersonnelMedical(id);
        List<com.doctorsarl.doctorsarl.entities.AffectationService> affections = affectationService.getAllAffectationsByPersonnel(personnelMedical);
        model.addAttribute("personnel",personnelMedical);
        model.addAttribute("affectations", affections);
        return "admin/personnel/show";
    }

    @GetMapping("/personnel_delete/{id}")
    public String deletePersonnel(@PathVariable("id") int id){
        personnelMedicalService.deletePersonnelById(id);
        return "redirect:/admin/personnels";
    }
}
