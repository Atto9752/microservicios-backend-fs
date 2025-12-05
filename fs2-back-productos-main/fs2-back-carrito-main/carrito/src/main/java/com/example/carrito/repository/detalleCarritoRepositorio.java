package com.example.carrito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrito.model.dto.detalleCarrito;

public interface detalleCarritoRepositorio extends JpaRepository<detalleCarrito, Long> {

}
