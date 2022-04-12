package com.challenge.Repositorio;

import java.util.Set;

import com.challenge.Personaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje,Integer>{

   @Query("from Personaje p where p.nombre like %:nombre% AND p.peso = :peso")
    Set<Personaje> getPersonajePorNombre(@Param("nombre") String nombre,@Param("peso") Double peso);
    /*@Query("from Personaje p where p.nombre like %:nombre%")
    Set<Personaje> getPersonajePorNombre(@Param("nombre") String nombre);*/
}
