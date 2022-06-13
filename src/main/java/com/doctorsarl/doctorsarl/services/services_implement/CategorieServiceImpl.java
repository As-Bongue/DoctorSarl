package com.doctorsarl.doctorsarl.services.services_implement;

import com.doctorsarl.doctorsarl.entities.Categorie;
import com.doctorsarl.doctorsarl.repository.CategorieRepository;
import com.doctorsarl.doctorsarl.services.interface_services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie saveCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public Categorie updateCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public void deleteCategorie(Categorie c) {
        categorieRepository.delete(c);
    }

    @Override
    public void deleteById(int id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie getCategorie(int id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }
}
