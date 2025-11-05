package com.example.elarayax.naves.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Faccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreFaccion", length = 30, nullable = false)
    private String nombre;

    @Column(name = "descripcionFaccion", length = 250, nullable = false)
    private String descripcion;

    @Column(name = "logoFaccion", nullable = false)
    private String logo;
}
