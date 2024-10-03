package com.apptienda.app_tienda.domain.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "productos")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private Set<CompraProducto> compraProducto;
}
