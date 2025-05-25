package com.library.projetmvc_tp6.service;

import com.library.projetmvc_tp6.entities.Categorie;
import com.library.projetmvc_tp6.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategorie implements IServiceCategorie {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public Categorie create(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public Categorie update(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public void delete(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie readOne(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categorie> readAll() {
        return categorieRepository.findAll();
    }
}
