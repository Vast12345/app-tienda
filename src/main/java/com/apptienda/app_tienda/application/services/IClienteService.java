package com.apptienda.app_tienda.application.services;

import java.util.List;
import java.util.Optional;

import com.apptienda.app_tienda.domain.entities.Cliente;

public interface IClienteService {
    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente cliente);

    Optional<Cliente> update(Long id, Cliente cliente);

    Optional<Cliente> delete(Long id);
}
