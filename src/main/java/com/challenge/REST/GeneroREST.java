package com.challenge.REST;

import java.util.List;

import com.challenge.Genero;
import com.challenge.Servicio.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genero")
public class GeneroREST {
    
    @Autowired
    private GeneroService generoService;

    @GetMapping
    private ResponseEntity<List<Genero>>getAllGeneros(){
        return ResponseEntity.ok(generoService.findAll());
    }

    //CREAR GENERO
    @PostMapping("/guardar")
    public ResponseEntity<Genero>guardar(@RequestBody Genero genero) {
        return ResponseEntity.ok(generoService.save(genero));
    }
    
}
