package com.example.admin.client;

import com.example.admin.model.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class UsuarioClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${usuario.service.url}")
    private String url;

    public List<UsuarioDTO> listarUsuarios() {
        UsuarioDTO[] usuarios = restTemplate.getForObject(url + "/api/v1/usuarios/all", UsuarioDTO[].class);
        return Arrays.asList(usuarios);
    }
}
