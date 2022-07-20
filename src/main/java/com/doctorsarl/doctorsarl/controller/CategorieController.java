package com.doctorsarl.doctorsarl.controller;

import com.doctorsarl.doctorsarl.entities.Categorie;
import com.doctorsarl.doctorsarl.services.interface_services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/categorie_create")
    public String saveCategorie(Categorie categorie, RedirectAttributes ra){
        categorieService.saveCategorie(categorie);
        ra.addFlashAttribute("message", "blaaaaaaaaa");
        return "redirect:/categories";
    }

    @GetMapping("/categorie_edit/{id}")
    public String showEditCategorieForm(@PathVariable("id") int id, Model model){
        Categorie categorie = categorieService.getCategorie(id);
        model.addAttribute("categorie", categorie);
        return "categorie/create_form";
    }

    @GetMapping("/categorie_delete/{id}")
    public String deleteCategorie(@PathVariable("id") int id){
        categorieService.deleteById(id);
        return "redirect:/categories";
    }

}
