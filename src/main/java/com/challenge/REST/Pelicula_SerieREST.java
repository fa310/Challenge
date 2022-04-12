package com.challenge.REST;


import java.util.List;

import com.challenge.Pelicula_Serie;
import com.challenge.Servicio.Pelicula_SerieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("peliculasyseries")
public class Pelicula_SerieREST {

    @Autowired
    private Pelicula_SerieService pelicula_serieService;

    //CREAR PELICULA O SERIE
   @PostMapping("/guardar")
    public ResponseEntity<Pelicula_Serie>guardar(@RequestBody Pelicula_Serie pelicula_serie) {
       return ResponseEntity.ok(pelicula_serieService.save(pelicula_serie));
    }

    //LEER PELICULA O SERIE
    @GetMapping ResponseEntity<List<Pelicula_Serie>>getAllPeliculasySeries(){
        return ResponseEntity.ok(pelicula_serieService.findAll());
    }

    /*@PutMapping("/{idPelicula_serie}/personajes/{idPersonaje}")
    public Pelicula_Serie enrolledPersonajes(@PathVariable int idPelicula_serie,@PathVariable int idPersonaje){
        Pelicula_Serie p = pelicula_serie.Repository
            return null;
    } */
    
    
}
