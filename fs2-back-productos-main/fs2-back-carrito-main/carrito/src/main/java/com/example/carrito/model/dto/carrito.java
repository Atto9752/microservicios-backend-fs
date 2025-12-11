package com.example.carrito.model.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CARRITOS")

public class carrito {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "ID_CARRITO")
    private Long idCarrito;

    @Column(name = "ID_USUARIO", nullable = false)
    private int idUsuario;

    @Column(name = "FECHA_CREACION")
    private String fechaCreacion;

    @OneToMany(mappedBy = "carrito", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
    private List<detalleCarrito> items;

    @Transient //para no guardarlo en la base de datos y mostrar el total al usuario
    private Double total;

    @Column(name = "COMPRADO", nullable = false)
    private boolean comprado = false; // false por defecto

}
