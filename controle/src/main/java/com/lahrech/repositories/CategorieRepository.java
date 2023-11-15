package com.lahrech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lahrech.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
