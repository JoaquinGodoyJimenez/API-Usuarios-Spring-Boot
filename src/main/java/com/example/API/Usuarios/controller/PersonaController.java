package com.example.API.Usuarios.controller;

import com.example.API.Usuarios.model.Persona;
import com.example.API.Usuarios.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable int id) {
        return personaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable int id) {
        personaRepository.deleteById(id);
    }
}