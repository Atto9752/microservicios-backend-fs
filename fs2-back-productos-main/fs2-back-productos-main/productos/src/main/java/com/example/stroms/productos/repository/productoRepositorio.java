package com.example.stroms.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stroms.productos.model.dto.producto;

public interface productoRepositorio extends JpaRepository<producto, Integer> {

}
