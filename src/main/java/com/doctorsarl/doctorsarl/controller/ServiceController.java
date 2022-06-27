package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.Categorie;
import com.doctorsarl.doctorsarl.entities.PersonnelMedical;
import com.doctorsarl.doctorsarl.entities.Service;
import com.doctorsarl.doctorsarl.services.interface_services.CategorieService;
import com.doctorsarl.doctorsarl.services.interface_services.PersonnelMedicalService;
import com.doctorsarl.doctorsarl.services.interface_services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private PersonnelMedicalService personnelMedicalService;

    @GetMapping("/services")
    public String showAllServices(Model model){
        List<Service> services = serviceService.getAllServices();
        model.addAttribute("services", services);
        return "services/show_all";
    }

    @GetMapping("/service_create")
    public String showCreateServiceForm(Model model){
        List<Categorie> categories = categorieService.getAllCategorie();
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedical();

        model.addAttribute("service", new Service());
        model.addAttribute("categories", categories);
        model.addAttribute("personnels", personnelMedicals);

        return "services/create_form";
    }

    @PostMapping("/service_create")
    public String createService(Service service){
        serviceService.saveService(service);
        return "redirect:/services";
    }

    @GetMapping("/service_edit/{id}")
    public String showEditServiceForm(@PathVariable("id") int id, Model model){
        Service service = serviceService.getService(id);
        model.addAttribute("service", service);

        List<Categorie> categories = categorieService.getAllCategorie();
        List<PersonnelMedical> personnelMedicals = personnelMedicalService.getAllPersonnelMedical();

        model.addAttribute("categories", categories);
        model.addAttribute("personnels", personnelMedicals);
        return "services/create_form";
    }

    @GetMapping("/service_delete/{id}")
    public String deleteService(@PathVariable("id") int id, Model model){
        serviceService.deleteById(id);
        return "redirect:/services";
    }

}
