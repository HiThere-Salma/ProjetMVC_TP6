package com.library.projetmvc_tp6.repository;

import com.library.projetmvc_tp6.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
