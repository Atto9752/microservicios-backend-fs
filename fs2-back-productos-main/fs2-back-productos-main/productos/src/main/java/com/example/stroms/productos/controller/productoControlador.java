package com.example.stroms.productos.controller;

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

import com.example.stroms.productos.model.dto.producto;
import com.example.stroms.productos.service.productoService;

@RestController
@RequestMapping("/api/v1/productos")
public class productoControlador {

    //para que cuando se levante el controlador se inicie el servicio
    @Autowired
    private productoService servicio;

    @GetMapping("/all")
    public List<producto> listarProductos() {
        return servicio.listarProductos();
    }

    @PostMapping("/add")
    public producto guardarProducto(@RequestBody producto producto) {
        return servicio.guardarProducto(producto);
    }

    @GetMapping("/search")
    public producto buscarProducto(@RequestParam int id) {
        return servicio.buscarProducto(id);
    }

    @DeleteMapping("/delete")
    public void eliminarProducto(@RequestParam int id) {
        servicio.eliminarProducto(id);
    }

    @PutMapping("/update")
    public producto actualizarProducto(@RequestParam int id, @RequestBody producto productoActualizado) {
        return servicio.actualizarProducto(id, productoActualizado);
    }
}
