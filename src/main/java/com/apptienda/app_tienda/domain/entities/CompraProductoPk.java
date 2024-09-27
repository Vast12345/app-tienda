package com.apptienda.app_tienda.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CompraProductoPk implements Serializable {

    @Column(name = "id_compra")
    private Long idcompra;

    @Column(name = "id_producto")
    private Long idproducto;
}
