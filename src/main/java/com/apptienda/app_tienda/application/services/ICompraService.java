package com.apptienda.app_tienda.application.services;

import java.util.List;
import java.util.Optional;

import com.apptienda.app_tienda.domain.entities.Compra;

public interface ICompraService {
    List<Compra> findAll();
    Optional<Compra> findById(Long id);

    Compra save(Compra compra);

    Optional<Compra> update(Long id, Compra compra);

    Optional<Compra> delete(Long id);
}
