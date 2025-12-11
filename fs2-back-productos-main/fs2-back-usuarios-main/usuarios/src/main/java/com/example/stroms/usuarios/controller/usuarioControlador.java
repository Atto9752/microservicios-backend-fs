package com.example.stroms.usuarios.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.stroms.usuarios.model.dto.usuario;
import com.example.stroms.usuarios.service.usuarioService;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "*")
public class usuarioControlador {

    @Autowired //para que cuando se levante el controlador se inicie el servicio 
    private usuarioService servicio;

    // DTO para manejar la peticion del login
    @Getter
    @Setter
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginRequest {
        private String username;
        private String contrasena;
    }

    @GetMapping("/all")
    public List<usuario> listarUsuarios() {
        return servicio.listarUsuarios();
    }

    @PostMapping("/add")
    public usuario guardarUsuario(@RequestBody usuario usuario) {
        return servicio.guardarUsuario(usuario);
    }

    @DeleteMapping("/delete")
    public void eliminarUsuario(@RequestParam int id) {
        servicio.eliminarUsuario(id);
    }

    @GetMapping("/search")
    public usuario buscarUsuario(@RequestParam int id) {
        return servicio.buscarUsuario(id);
    }

    @PutMapping("/update")    
    public usuario actualizarUsuario(@RequestParam int id, @RequestBody usuario usuarioActualizado) {
        return servicio.actualizarUsuario(id, usuarioActualizado);
    }

    // PARA AUTORIZAR ACCESO A PANEL DE ADMINISTRADOR
    @GetMapping("/rol/{username}")
    public ResponseEntity<String> obtenerRolPorUsername(@PathVariable String username) {
        String rol = servicio.obtenerRolPorUsername(username); 
        return ResponseEntity.ok(rol); 
    }

    // recibe el username y la contra del front y devuelve el rol si las credenciales son validas
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest request) {
        boolean valido = servicio.verificarCredenciales(request.getUsername(), request.getContrasena());
        
        if (valido) {
            // credenciales correctas (200 ok)
            return ResponseEntity.ok().build(); 
        } else {
            // credenciales incorrectas (401)
            return ResponseEntity.status(401).build(); 
        }
    }

}
