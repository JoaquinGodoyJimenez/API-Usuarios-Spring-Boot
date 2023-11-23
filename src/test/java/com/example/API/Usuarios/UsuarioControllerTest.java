package com.example.API.Usuarios;

import com.example.API.Usuarios.controller.UsuarioController;
import com.example.API.Usuarios.model.Usuario;
import com.example.API.Usuarios.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    void getAllUsuarios() throws Exception {
        // Arrange
        Usuario usuario1 = new Usuario(1, "user1", "password1", null, null, null);
        Usuario usuario2 = new Usuario(2, "user2", "password2", null, null, null);
        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);

        Mockito.when(usuarioService.getAll()).thenReturn(usuarios);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(usuarios)));
    }

    @Test
    void getUsuarioById() throws Exception {
        // Arrange
        int userId = 1;
        Usuario usuario = new Usuario(userId, "user1", "password1", null, null, null);

        Mockito.when(usuarioService.getById(userId)).thenReturn(usuario);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/{id}", userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(usuario)));
    }

    @Test
    void createUsuario() throws Exception {
        // Arrange
        Usuario usuario = new Usuario(1, "user1", "password1", null, null, null);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteUsuario() throws Exception {
        // Arrange
        int userId = 1;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/usuarios/{id}", userId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
