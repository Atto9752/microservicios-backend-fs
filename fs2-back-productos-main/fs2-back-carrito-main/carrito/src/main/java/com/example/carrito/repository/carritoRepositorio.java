package com.example.carrito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrito.model.dto.carrito;

public interface carritoRepositorio extends JpaRepository<carrito, Long> {

}
