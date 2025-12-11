package com.example.carrito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrito.model.dto.carrito;
import com.example.carrito.service.carritoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/carritos")
@CrossOrigin(origins = "*")
public class carritoControlador {

    @Autowired // para que cuando se levante el controlador se inicie el servicio
    private carritoService servicio;

    @GetMapping("/all")
    public List<carrito> listarCarritos() {
        return servicio.listarCarritos();
    }

    @PostMapping("/add")
    public carrito guardarCarrito(@RequestBody carrito carrito) {
        return servicio.guardarCarrito(carrito);
    }

    @DeleteMapping("/delete")
    public void eliminarCarrito(@RequestParam Long id) {
        servicio.eliminarCarrito(id);
    }

    @GetMapping("/search")
    public carrito buscarCarrito(@RequestParam Long id) {
        return servicio.buscarCarrito(id);
    }

    @PutMapping("/update")
    public carrito actualizarCarrito(@RequestParam Long id, @RequestBody carrito carrito) {
        return servicio.actualizarCarrito(id, carrito);
    }

    @GetMapping("/productos-externos")
    public List<com.example.carrito.model.dto.ProductoDTO> listarProductosExternos() {
        return servicio.listarProductosExternos();
    }

    @GetMapping("/usuarios-externos")
    public List<com.example.carrito.model.dto.UsuarioDTO> listarUsuariosExternos() {
        return servicio.listarUsuariosExternos();
    }

}
