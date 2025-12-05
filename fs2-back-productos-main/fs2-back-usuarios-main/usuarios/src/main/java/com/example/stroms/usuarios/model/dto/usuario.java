package com.example.stroms.usuarios.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USUARIOS")

public class usuario {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private int id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "CORREO", nullable = false, unique = true)
    private String correo;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "CONTRASENA", nullable = false)
    private String contrasena;

    // para que use la clase rol como referencia de llave foranea
    // y como valor tenga el id del rol
    @ManyToOne
    @JoinColumn(name = "ID_ROL", nullable = false)
    private rol rol;

}
