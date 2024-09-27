package com.apptienda.app_tienda.application.services;

import com.apptienda.app_tienda.domain.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    Producto save(Producto producto);

    Optional<Producto> update(Long id, Producto producto);

    Optional<Producto> delete(Long id);
}
