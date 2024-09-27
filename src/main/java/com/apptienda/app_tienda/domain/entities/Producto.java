package com.apptienda.app_tienda.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String nombre;

    @Column(length = 150, nullable = false, name = "codigo_barras")
    private String codigobarras;

    @Column(nullable = false, columnDefinition = "Decimal(16, 2)", name = "precio_venta")
    private Float precioventa;

    @Column(nullable = false, name = "cantidad_stock")
    private int cantidadstock;

    @Column(nullable = false, columnDefinition = "tinyint")
    private boolean estado;

    @ManyToOne
    private Categoria categoria;

}
