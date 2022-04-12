package com.challenge;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "peliculas_series")
public class Pelicula_Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPelicula_serie;

    @Column(name="imagen", length= 150)
    private String imagen;

    @Column(name= "titulo", length = 25)
    private String titulo;

    @Column(name="fechaDeCreacion")
    private Date fechaDeCreacion;
    
    @Column(name="calificacion" )
    private Integer calificacion;

    private Integer genero_fk;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "jnd_Pelicula_Personaje",
            joinColumns = @JoinColumn(name="Pelicula_Serie_fk"),
            inverseJoinColumns = @JoinColumn(name="Personaje_fk"))
    //@JsonIgnore
    private Set<Personaje> personajes = new HashSet<>();


    //constructor
    public Pelicula_Serie(){

    }
    
    public Pelicula_Serie(String imagen, String titulo, Date fechaDeCreacion, Integer calificacion,Integer genero_fk,
        Set<Personaje> personajes) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.calificacion = calificacion;
        this.genero_fk = genero_fk;
        this.personajes = personajes;
    }

    //getter and setters
    public Integer getIdPelicula_serie() {
        return idPelicula_serie;
    }

    public void setIdPelicula_serie(Integer idPelicula_serie) {
        this.idPelicula_serie = idPelicula_serie;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getGenero_fk() {
        return genero_fk;
    }

    public void setGenero_fk(Integer genero_fk) {
        this.genero_fk = genero_fk;
    }

    public Set<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Set<Personaje> personajes) {
        this.personajes = personajes;
    }  

    /*public List<Personaje> getPersonajes() {
        return personajes;
    }
    
    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }*/

    
}
