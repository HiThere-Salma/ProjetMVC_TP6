package com.library.projetmvc_tp6.controller;

import com.library.projetmvc_tp6.entities.Film;
import com.library.projetmvc_tp6.service.IServiceCategorie;
import com.library.projetmvc_tp6.service.IServiceFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FilmController {

    @Autowired
    private IServiceFilm serviceFilm;
    @Autowired
    private IServiceCategorie serviceCategorie;
    @GetMapping("/film/all")
    public String listeFilms(Model model) {
        model.addAttribute("films", serviceFilm.readAll());
        return "dashboard"; // vue à créer
    }

    @GetMapping("/film/new")
    public String newFilm(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("categories", serviceCategorie.readAll());
        return "formFilm"; // formFilm.html
    }


    @PostMapping("/film/save")
    public String saveFilm(@ModelAttribute Film film, RedirectAttributes redirectAttributes) {
        serviceFilm.create(film);
        redirectAttributes.addFlashAttribute("message", "✅ Film enregistré avec succès !");
        return "redirect:/film/all";
    }

    @GetMapping("/film/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        serviceFilm.delete(id);
        return "redirect:/film/all";
    }
    @PostMapping("/film/find")
    public String findFilm(@RequestParam String mot, Model model) {
        List<Film> results = serviceFilm.searchByKeyword(mot); // méthode fictive
        model.addAttribute("films", results);
        return "affiche";
    }
    @GetMapping("/film/edit/{id}")
    public String editFilm(@PathVariable Long id, Model model) {
        model.addAttribute("film", serviceFilm.readOne(id));
        model.addAttribute("categories", serviceCategorie.readAll());
        return "formFilm";
    }


}
