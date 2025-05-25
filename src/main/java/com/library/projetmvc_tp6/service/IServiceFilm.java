package com.library.projetmvc_tp6.service;

import com.library.projetmvc_tp6.entities.Film;

import java.util.List;

public interface IServiceFilm {
    Film create(Film f);
    Film update(Film f);
    void delete(Long id);
    Film readOne(Long id);
    List<Film> readAll();

    List<Film> searchByKeyword(String mot);
}
