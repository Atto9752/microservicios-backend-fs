package com.example.stroms.usuarios.model.dto;

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
@Table(name = "ROLES")
public class rol {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "ID_ROL")
    private int id;

    //nombres del rol como "ADMIN", "USER", etc.
    @Column(name = "NOMBRE_ROL", unique = true, nullable = false)
    private String nombreRol; // CLIENTE O ADMIN

}
