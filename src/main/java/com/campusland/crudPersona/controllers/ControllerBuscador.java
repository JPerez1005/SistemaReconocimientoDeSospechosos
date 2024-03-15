package com.campusland.crudPersona.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.campusland.crudPersona.repositories.entities.Persona;
import com.campusland.crudPersona.services.ServicePersona;

@RestController
@RequestMapping("/buscador")
public class ControllerBuscador {

    private final ServicePersona sp;

    public ControllerBuscador(ServicePersona sp) {
        this.sp = sp;
    }

    @PostMapping("/buscar-sospechoso")
    public Map<String, Object> buscarSospechoso(@RequestBody String muestraCromosoma) {
        List<Persona> personas = sp.findAll();

        System.out.println("Longitud de la muestra de cromosoma: " + muestraCromosoma.length());
        System.out.println(muestraCromosoma);

        String nombreSospechoso = null;
        int maxCoincidencias = 0;

        for (Persona persona : personas) {
            String cromosoma = persona.getCromosoma();
            System.out.println("Longitud del cromosoma de " + persona.getNombre() + ": " + cromosoma.length());
            int coincidencias = contarCoincidencias(muestraCromosoma, cromosoma);
            if (coincidencias > maxCoincidencias) {
                maxCoincidencias = coincidencias;
                nombreSospechoso = persona.getNombre();
            }
        }

        double porcentajeParentesco = ((double) maxCoincidencias / muestraCromosoma.length()) * 100;

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("nombreSospechoso", nombreSospechoso);
        resultado.put("porcentajeParentesco", porcentajeParentesco);

        return resultado;
    }

    private int contarCoincidencias(String muestra, String cromosoma) {
        if (muestra.length() != 20 || cromosoma.length() != 20) {
            throw new IllegalArgumentException("Las cadenas deben tener una longitud de 20 caracteres");
        }
    
        int coincidencias = 0;
        for (int i = 0; i < muestra.length(); i++) {
            if (muestra.charAt(i) == cromosoma.charAt(i)) {
                coincidencias++;
            }
        }
        return coincidencias;
    }
    
}
