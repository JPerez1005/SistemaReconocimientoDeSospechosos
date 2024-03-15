package com.campusland.crudPersona.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campusland.crudPersona.repositories.entities.Persona;

public interface RepositoryPersona  extends CrudRepository<Persona,Long>{
    
}
