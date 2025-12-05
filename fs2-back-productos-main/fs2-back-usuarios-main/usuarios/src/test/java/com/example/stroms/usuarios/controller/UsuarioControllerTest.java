package com.example.stroms.usuarios.controller;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.stroms.usuarios.model.dto.usuario;
import com.example.stroms.usuarios.service.usuarioService;

@WebMvcTest(controllers = usuarioControlador.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private usuarioService servicio;

    @Test
    public void testListarUsuarios(){
        usuario usuario1 = new usuario(1, "Juan Perez", "juan.perez@example.com", "Calle Falsa 123", "password123", null);
        usuario usuario2 = new usuario(2, "Maria Gomez", "maria.gomez@example.com", "Avenida Siempre Viva 456", "password456", null);
        
        when(servicio.listarUsuarios()).thenReturn(List.of(usuario1, usuario2));

        mockMvc.perform(get("/api/v1/usuarios/all"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()").value(2))
               .andExpect(jsonPath("$[0].nombre").value("Juan Perez"))
               .andExpect(jsonPath("$[1].nombre").value("Maria Gomez"));
    }
}
