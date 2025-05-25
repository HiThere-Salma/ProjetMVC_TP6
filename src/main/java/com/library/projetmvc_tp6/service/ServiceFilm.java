package com.library.projetmvc_tp6.service;

import com.library.projetmvc_tp6.entities.Film;
import com.library.projetmvc_tp6.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFilm implements IServiceFilm {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film create(Film f) {
        return filmRepository.save(f);
    }

    @Override
    public Film update(Film f) {
        return filmRepository.save(f);
    }

    @Override
    public void delete(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public Film readOne(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public List<Film> readAll() {
        List<Film> list = filmRepository.findAll();
        System.out.println("Films chargés = " + list.size());
        return list;
    }


    @Override
    public List<Film> searchByKeyword(String mot) {
        return List.of();
    }
}
