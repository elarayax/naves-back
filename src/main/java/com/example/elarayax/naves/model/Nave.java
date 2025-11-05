package com.example.elarayax.naves.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Nave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreNave", length = 50, nullable = false)
    private String nombre;

    @Column(name = "modeloNave", length = 30, nullable = false)
    private String modelo;

    @Column(name = "urlNave", nullable = false)
    private String url;

    @Column(name = "descripcionNave", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "codigo_faccion")
    private Faccion faccion;

    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    private Usuario usuario;
}
