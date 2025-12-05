package com.example.stroms.productos.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCTOS")

public class producto {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private int id;

    @Column(name = "NOMBRE", nullable = false, unique = true)
    private String nombre;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    @Column(name = "DESCRIPCION", nullable = true)
    private String descripcion;

    @Column(name = "PRECIO", nullable = false)
    private double precio;

}
