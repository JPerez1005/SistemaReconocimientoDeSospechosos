package com.campusland.crudPersona.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.campusland.crudPersona.repositories.entities.Persona;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.campusland.crudPersona.services.ServicePersona;



@RestController
@RequestMapping("/personas")
@AllArgsConstructor
public class ControllerPersona {

    private final ServicePersona sp;

    @GetMapping("/")
    public List<Persona> findAll() {
        return sp.findAll();
    }

    @GetMapping("/{id}")
    public Persona findAllByString(@PathVariable Long id) {
        return sp.findById(id);
    }

    @PostMapping("/")
    public Persona save(@RequestBody Persona cliente) {
        return sp.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        sp.delete(id);
    }   
    
}
