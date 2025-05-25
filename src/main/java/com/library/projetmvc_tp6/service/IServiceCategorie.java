package com.library.projetmvc_tp6.service;

import com.library.projetmvc_tp6.entities.Categorie;

import java.util.List;

public interface IServiceCategorie {
    Categorie create(Categorie c);
    Categorie update(Categorie c);
    void delete(Long id);
    Categorie readOne(Long id);
    List<Categorie> readAll();
}
