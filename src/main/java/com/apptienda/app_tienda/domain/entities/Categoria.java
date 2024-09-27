package com.apptienda.app_tienda.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categorias")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=45, nullable=false)
    private String descripcion;

    @Column(nullable=false, columnDefinition="tinyint(1)")
    private boolean estado;
}
