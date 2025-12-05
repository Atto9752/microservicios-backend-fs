package com.example.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.admin.model.dto.admin;
import com.example.admin.service.adminService;

@RestController
@RequestMapping("/api/v1/admins")
public class adminControlador {

    // para que cuando se levante el controlador se inicie el servicio
    @Autowired
    private adminService servicio;

    @GetMapping("/all")
    public List<admin> listarAdmins() {
        return servicio.listarAdmins();
    }

    @PostMapping("/add")
    public admin guardarAdmin(@RequestBody admin admin) {
        return servicio.guardarAdmin(admin);
    }

    @DeleteMapping("/delete")
    public void eliminarAdmin(@RequestParam int id) {
        servicio.eliminarAdmin(id);
    }

    @GetMapping("/search")
    public admin buscarAdmin(@RequestParam int id) {
        return servicio.buscarAdmin(id);
    }

    @PutMapping("/update")
    public admin actualizarAdmin(@RequestParam int id, @RequestBody admin adminActualizado) {
        return servicio.actualizarAdmin(id, adminActualizado);
    }

    @GetMapping("/usuarios-externos")
    public List<com.example.admin.model.dto.UsuarioDTO> listarUsuariosExternos() {
        return servicio.listarUsuariosExternos();
    }

}
