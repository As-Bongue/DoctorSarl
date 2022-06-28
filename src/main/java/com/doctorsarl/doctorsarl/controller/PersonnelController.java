package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
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
public class PersonnelController {

    @Autowired
    PersonnelMedicalService personnelMedicalService;

    @GetMapping("/personnels")
    public String showAllPersonnelMedical(Model model){
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedical();
        model.addAttribute("personnels", personnelMedicals);
        return "personnel/show_all";
    }

    @GetMapping("/personnel_create")
    public String showCreatePersonnelForm(Model model){
        model.addAttribute("personnel", new PersonnelMedical());
        return "personnel/create_form";
    }

    @PostMapping("/personnel_create")
    public String createPersonnel(PersonnelMedical personnelMedical, RedirectAttributes ra){
        personnelMedicalService.savePersonnelMedical(personnelMedical);
        ra.addFlashAttribute("message", "personnel enregistrer avec sucess");
        return "redirect:/personnels";
    }

    @GetMapping("/personnel_edit/{id}")
    public String showEditPersonnelForm(@PathVariable("id") int id, Model model){
        PersonnelMedical personnelMedical = personnelMedicalService.getPersonnelMedical(id);
        model.addAttribute("personnel", personnelMedical);
        return "personnel/edit_form";
    }

    @GetMapping("/personnel_delete/{id}")
    public String deletePersonnel(@PathVariable("id") int id){
        personnelMedicalService.deletePersonnelById(id);
        return "redirect:/personnels";
    }
}
