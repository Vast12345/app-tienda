package com.apptienda.app_tienda.application.services;

import java.util.List;
import java.util.Optional;

import com.apptienda.app_tienda.domain.entities.Categoria;

public interface ICategoriaService {
    List<Categoria> findAll();

    Optional<Categoria> findById(Long id);

    Categoria save(Categoria categoria);

    Optional<Categoria> update(Long id, Categoria categoria);

    Optional<Categoria> delete(Long id);
}
