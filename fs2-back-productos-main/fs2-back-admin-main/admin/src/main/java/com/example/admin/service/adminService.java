package com.example.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.model.dto.admin;
import com.example.admin.repository.adminRepositorio;

@Service
public class adminService {

    // para que se inicie junto con el repo y no se desconecten uno del otro
    @Autowired
    private adminRepositorio repositorio;

    @Autowired // inyeccion para buscar roles
    private rolRepositorio rolRepo;

    @Autowired
    private com.example.admin.client.UsuarioClient usuarioClient;

    public List<admin> listarAdmins() {
        return repositorio.findAll();
    }

    public admin guardarAdmin(admin admin) {

        Optional<rol> rolAdmin = rolRepo.findByNombreRol("ADMIN");

        if (rolAdmin.isEmpty()) {
            throw new RuntimeException("El rol ADMIN no esta configurado en la base de datos de ROLES.");
        }

        admin.setRol(rolAdmin.get());

        return repositorio.save(admin);

    }

    public void eliminarAdmin(int id) {
        repositorio.deleteById(id);
    }

    public admin buscarAdmin(int id) {
        return repositorio.findById(id).orElse(null);
    }

    public admin actualizarAdmin(int id, admin adminActualizado) {
        admin adminExistente = repositorio.findById(id).orElse(null);
        if (adminExistente != null) {
            adminExistente.setNombre(adminActualizado.getNombre());
            adminExistente.setCorreo(adminActualizado.getCorreo());
            adminExistente.setContrasena(adminActualizado.getContrasena());
            // el rol no se actualiza pq siempre tiene q ser "ADMIN"
            return repositorio.save(adminExistente);
        }
        return null;
    }

    public List<com.example.admin.model.dto.UsuarioDTO> listarUsuariosExternos() {
        return usuarioClient.listarUsuarios();
    }

}
