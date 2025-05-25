package com.library.projetmvc_tp6.controller;

import com.library.projetmvc_tp6.entities.Categorie;
import com.library.projetmvc_tp6.service.IServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategorieController {

    @Autowired
    private IServiceCategorie serviceCategorie;

    // Afficher toutes les catégories
    @GetMapping("/categorie/all")
    public String listeCategories(Model model) {
        List<Categorie> categories = serviceCategorie.readAll();
        model.addAttribute("categories", categories);
        return "afficheCategories"; // à créer
    }

    // Formulaire d'ajout de catégorie
    @GetMapping("/categorie/new")
    public String newCategorie(Model model) {
        model.addAttribute("categorie", new Categorie());
        return "formCategorie"; // à créer
    }

    // Enregistrer une catégorie
    @PostMapping("/categorie/save")
    public String saveCategorie(@ModelAttribute Categorie categorie) {
        serviceCategorie.create(categorie);
        return "redirect:/categorie/all";
    }

    // Supprimer une catégorie
    @GetMapping("/categorie/delete/{id}")
    public String deleteCategorie(@PathVariable Long id) {
        serviceCategorie.delete(id);
        return "redirect:/categorie/all";
    }

    // Modifier une catégorie
    @GetMapping("/categorie/edit/{id}")
    public String editCategorie(@PathVariable Long id, Model model) {
        Categorie categorie = serviceCategorie.readOne(id);
        model.addAttribute("categorie", categorie);
        return "formCategorie"; // même vue que pour l'ajout
    }
}
