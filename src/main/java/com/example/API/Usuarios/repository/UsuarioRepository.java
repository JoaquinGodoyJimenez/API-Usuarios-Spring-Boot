package com.example.API.Usuarios.repository;

import com.example.API.Usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("Select u from Usuario u where u.usuario = ?1")
    public Usuario login(String usuario);
}