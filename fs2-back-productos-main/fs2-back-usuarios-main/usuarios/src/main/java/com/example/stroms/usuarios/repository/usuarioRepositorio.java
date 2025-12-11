package com.example.stroms.usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stroms.usuarios.model.dto.usuario;

public interface usuarioRepositorio extends JpaRepository<usuario, Integer> {

    Optional<usuario> findByNombre(String nombre);
    
}
