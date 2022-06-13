package com.doctorsarl.doctorsarl.services.interface_services;

import com.doctorsarl.doctorsarl.entities.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie saveCategorie(Categorie c);
    Categorie updateCategorie(Categorie c);
    void deleteCategorie(Categorie c);
    void deleteById(int id);
    Categorie getCategorie(int id);
    List<Categorie> getAllCategorie();
}
