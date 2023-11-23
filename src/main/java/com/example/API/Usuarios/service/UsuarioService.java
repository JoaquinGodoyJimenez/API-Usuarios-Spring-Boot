package com.example.API.Usuarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.Usuarios.model.Usuario;
import com.example.API.Usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

    public List<Usuario> getAll(){
        List<Usuario> usuarios = new ArrayList<>();
        for(Usuario usuario : repo.findAll()){
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public Usuario getById(int id){
        Usuario usuario = repo.getById(id);
        return usuario;
    }

    public void add(Usuario usuario){
        repo.save(usuario);
    }
    
    public Usuario login(String username){
        return repo.login(username);
    }
}
