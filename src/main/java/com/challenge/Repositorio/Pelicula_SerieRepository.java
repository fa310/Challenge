package com.challenge.Repositorio;

import com.challenge.Pelicula_Serie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pelicula_SerieRepository extends JpaRepository<Pelicula_Serie,Integer>{
    
}
