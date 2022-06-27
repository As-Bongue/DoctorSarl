package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.Categorie;
import com.doctorsarl.doctorsarl.services.interface_services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @GetMapping("/categories")
    public String showCategorieList(Model model){
        List<Categorie> categories = categorieService.getAllCategorie();
        model.addAttribute("categories", categories);
        return "categorie/show_all";
    }

    @GetMapping("/categorie_create")
    public String showCreateCategorieForm(Model model){
        model.addAttribute("categorie", new Categorie());
        return "categorie/create_form";
    }

    @PostMapping("/categorie/create")
    public String saveCategorie(Categorie categorie, RedirectAttributes ra){
        categorieService.saveCategorie(categorie);
        ra.addFlashAttribute("message", "Categorie enregistrer avec sucess");
        return "redirect:/categories";
    }

}
