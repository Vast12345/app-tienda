package com.apptienda.app_tienda.infrastructure.repositories.cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apptienda.app_tienda.domain.entities.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long>{
    
}
