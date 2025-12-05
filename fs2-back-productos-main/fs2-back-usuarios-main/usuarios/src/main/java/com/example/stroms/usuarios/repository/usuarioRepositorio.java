package com.example.stroms.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stroms.usuarios.model.dto.usuario;

public interface usuarioRepositorio extends JpaRepository<usuario, Integer> {

    
}
