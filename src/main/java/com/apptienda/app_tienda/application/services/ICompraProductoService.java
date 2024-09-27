package com.apptienda.app_tienda.application.services;

import java.util.List;
import java.util.Optional;

import com.apptienda.app_tienda.domain.entities.Compra;
import com.apptienda.app_tienda.domain.entities.CompraProducto;
import com.apptienda.app_tienda.domain.entities.CompraProductoPk;

import javax.swing.text.html.Option;

public interface ICompraProductoService {
    CompraProducto save(CompraProducto compraProducto);


}
