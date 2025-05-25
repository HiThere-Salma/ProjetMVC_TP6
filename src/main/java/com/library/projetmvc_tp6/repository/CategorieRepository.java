package com.library.projetmvc_tp6.repository;

import com.library.projetmvc_tp6.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
