package com.apptienda.app_tienda.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "compras_productos")
@Data
public class CompraProducto {

    @EmbeddedId
    private CompraProductoPk id;

    @ManyToOne
    @MapsId("idcompra")
    @JoinColumn(name = "id_compra")
    private Compra compra;

    @ManyToOne
    @MapsId("idproducto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false, columnDefinition = "decimal(16, 2)")
    private float total;

    @Column(nullable = false, columnDefinition = "tinyint")
    private boolean estado;
}
