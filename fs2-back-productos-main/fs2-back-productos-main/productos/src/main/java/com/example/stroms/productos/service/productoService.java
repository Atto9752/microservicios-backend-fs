package com.example.stroms.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stroms.productos.model.dto.producto;
import com.example.stroms.productos.repository.productoRepositorio;

@Service
public class productoService {

    //para que se inicie junto con el repo y no se desconecten uno del otro
    @Autowired
    private productoRepositorio productoRepo;

    public List<producto> listarProductos() {
        return productoRepo.findAll();
    }

    public producto guardarProducto(producto producto) {
        return productoRepo.save(producto);
    }

    public producto buscarProducto(int id) {
        return productoRepo.findById(id).orElse(null);
    }

    public void eliminarProducto(int id) {
        productoRepo.deleteById(id);
    }

    public producto actualizarProducto(int id, producto productoActualizado) {
        producto productoExistente = productoRepo.findById(id).orElse(null);
        if (productoExistente != null) {
            productoExistente.setNombre(productoActualizado.getNombre());
            productoExistente.setCategoria(productoActualizado.getCategoria());
            productoExistente.setDescripcion(productoActualizado.getDescripcion());
            productoExistente.setPrecio(productoActualizado.getPrecio());
            return productoRepo.save(productoExistente);
        }
        return null;
    }

}
