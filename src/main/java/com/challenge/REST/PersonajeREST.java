package com.challenge.REST;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.challenge.Personaje;
import com.challenge.personajeDTO;
import com.challenge.Servicio.PersonajeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personajes")
public class PersonajeREST {
    
    @Autowired
    private PersonajeService personajeService;
    

    //CREAR PERSONAJE
    
    //CREAR PERSONAJE
   @PostMapping("/guardar")
   public ResponseEntity<Personaje>guardar(@RequestBody Personaje personaje) {
      return ResponseEntity.ok(personajeService.save(personaje));
    }
    //LEER PERSONAJE
    @GetMapping
    private ResponseEntity<List<Personaje>>getAllPersonajes(){
        return ResponseEntity.ok(personajeService.findAll());
    }

    //ELIMINAR PERSONAJE
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        personajeService.deleteById(id);
    }

    //ACTUALIZAR PERSONAJE
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Personaje>actualizar(@RequestBody Personaje personaje,@PathVariable("id") Integer id){
        return ResponseEntity.ok(personajeService.save(personajeService.actualizar(personaje, id)));
    }

    //DETALLE PERSONAJE
    @GetMapping("/detalle/{id}")
    private ResponseEntity<Optional<Personaje>> getPersonaje(@PathVariable("id") Integer id){
        return ResponseEntity.ok(personajeService.findById(id));
    }

    //BUSCAR PERSONAJE POR NOMBRE

    @GetMapping("/character")
    private ResponseEntity<Set<personajeDTO>> buscarPersonajePorNombre(@RequestParam (name="nombre",defaultValue ="null")String nombre,
                                                                        @RequestParam (name="peso",defaultValue = "0")Double peso){
        return ResponseEntity.ok(personajeService.buscarPersonaje(nombre,peso));
    }

    /*@GetMapping("/character")
    private ResponseEntity<Set<personajeDTO>> buscarPersonajePorNombre(@RequestParam (name="nombre",defaultValue ="null")String nombre){
        return ResponseEntity.ok(personajeService.buscarPersonaje(nombre));
    }*/

}
