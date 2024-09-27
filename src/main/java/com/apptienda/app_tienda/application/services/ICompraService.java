package com.apptienda.app_tienda.application.services;

import com.apptienda.app_tienda.domain.entities.Compra;

import java.util.List;
import java.util.Optional;

public interface ICompraService {
    List<Compra> findAll();

    Optional<Compra> findById(Long id);

    Compra save(Compra compra);

    Optional<Compra> update(Long id, Compra compra);

    Optional<Compra> delete(Long id);
}
