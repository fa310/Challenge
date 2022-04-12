package com.challenge.Servicio;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import com.challenge.Personaje;
import com.challenge.personajeDTO;
import com.challenge.Repositorio.PersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService implements PersonajeRepository{

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private ObjectMapper mapper;

    //IMPLEMENTADO
    @Override
    public List<Personaje> findAll() {
        return personajeRepository.findAll();
    }

    /*public List<Personaje> findAllByPeliculaSerie(){
        List<Personaje> personajesRespuesta=null;
        List<Personaje> personajes = personajeRepository.findAll();
        for(int i=0; i<personajes.size();i++){
            if(personajes.get(i).getPeliculasyseries().getId()==id){
                personajesRespuesta.add(personajes.get(i));
            }
        }
        return personajesRespuesta;
    }*/
    //Actualizar Personaje
    public Personaje actualizar(Personaje personaje,Integer id){
        Personaje p = personajeRepository.getById(id);
        p.setEdad(personaje.getEdad());
        p.setHistoria(personaje.getHistoria());
        p.setImagen(personaje.getImagen());
        p.setNombre(personaje.getNombre());
        p.setPeso(personaje.getPeso());

        return p;
    }

    public Set<personajeDTO> buscarPersonaje(String nombre,Double peso) {
        Set<Personaje> allPersonajes = personajeRepository.getPersonajePorNombre(nombre,peso);
        Set<personajeDTO> allPersonajesDTO = new HashSet<>();
        for(Personaje personaje: allPersonajes)
            allPersonajesDTO.add(mapper.convertValue(personaje,personajeDTO.class));

        return allPersonajesDTO;
    }

    /*public Set<personajeDTO> buscarPersonaje(String nombre) {
        Set<Personaje> allPersonajes = personajeRepository.getPersonajePorNombre(nombre);
        Set<personajeDTO> allPersonajesDTO = new HashSet<>();
        for(Personaje personaje: allPersonajes)
            allPersonajesDTO.add(mapper.convertValue(personaje,personajeDTO.class));

        return allPersonajesDTO;
    }*/

    @Override
    public List<Personaje> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Personaje> findAllById(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Personaje> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <S extends Personaje> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Personaje> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Personaje> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Personaje getOne(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    //IMPLEMMENTADO
    @Override
    public Personaje getById(Integer id) {
        return personajeRepository.getById(id);
    }

    @Override
    public <S extends Personaje> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Personaje> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Personaje> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    //ELIMINAR
    @Override
    public void delete(Personaje entity) {
        personajeRepository.delete(entity);   
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<? extends Personaje> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        // TODO Auto-generated method stub
        
    }

    //ELIMINAR POR ID
    @Override
    public void deleteById(Integer id) {
        personajeRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Optional<Personaje> findById(Integer id) {
        return personajeRepository.findById(id);
    }

    //Guardar
    @Override
    public <S extends Personaje> S save(S entity) {
        return personajeRepository.save(entity);
    }

    @Override
    public <S extends Personaje> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends Personaje> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <S extends Personaje> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Personaje, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Personaje> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    /*@Override
    public Set<Personaje> getPersonajePorNombre(String nombre) {
        // TODO Auto-generated method stub
        return null;
    }*/

    @Override
    public Set<Personaje> getPersonajePorNombre(String nombre, Double peso) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
