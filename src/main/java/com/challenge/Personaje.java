package com.challenge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.challenge.Servicio.Pelicula_SerieService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersonaje;
    
    @Column(name="imagen", length= 150)
    private String imagen;

    @Column(name= "nombre", length = 25)
    private String nombre;

    @Column(name="edad")
    private Integer edad;
    
    @Column(name="peso")
    private Double peso;

    @Column(name="historia", length = 55)
    private String historia;

    @ManyToMany(mappedBy = "personajes")
    @JsonBackReference
    //@JsonIgnore
    private Set<Pelicula_Serie> peliculasyseries = new HashSet<>();

    //@Autowired
    //sprivate Pelicula_SerieService pelicula_serieService;
    //constructor
    public Personaje(){
        
    }
    public Personaje(String imagen, String nombre, Integer edad, Double peso, String historia,
            Set<Pelicula_Serie> peliculasyseries) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculasyseries = peliculasyseries;
    }

    //getters and setters
    public Integer getIdPersonaje(int i) {
        return idPersonaje;
    }

    public void setIdPersonaje(Integer idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Set<Pelicula_Serie> getPeliculasyseries() {
        return peliculasyseries;
    }
    public void setPeliculasyseries(Set<Pelicula_Serie> peliculasyseries) {
        this.peliculasyseries = peliculasyseries;
    }

    
    /*
    public List<Pelicula_Serie> getPeliculasyseries() {
       return peliculasyseries;
    }

    public void setPeliculasyseries(List<Pelicula_Serie> peliculasyseries) {
        this.peliculasyseries = peliculasyseries;
    }*/
}
