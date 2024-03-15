package com.campusland.crudPersona.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campusland.crudPersona.repositories.entities.Persona;

import lombok.AllArgsConstructor;
import com.campusland.crudPersona.repositories.RepositoryPersona;
import com.campusland.crudPersona.services.ServicePersona;

@Service
@AllArgsConstructor
public class ServiceImplPersona implements ServicePersona {

    private final RepositoryPersona rp;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) rp.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) {
        return rp.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return rp.save(persona);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Persona> clienteOptinal=rp.findById(id);
        if(clienteOptinal.isPresent()){
            rp.delete(clienteOptinal.get());
        }       
    }

}
