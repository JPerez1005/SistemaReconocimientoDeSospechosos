package com.campusland.crudPersona.services;

import java.util.List;

import com.campusland.crudPersona.repositories.entities.Persona;


public interface ServicePersona {
    
    List<Persona> findAll();

    Persona findById(Long id);

    Persona save(Persona persona);

    void delete(Long id);
    
}
