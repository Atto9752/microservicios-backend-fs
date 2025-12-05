package com.example.stroms.usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stroms.usuarios.model.dto.rol;

public interface rolRepositorio extends JpaRepository<rol, Integer> {

    Optional<rol> findByNombreRol(String nombreRol);

}
