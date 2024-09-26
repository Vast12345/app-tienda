package com.apptienda.app_tienda.infrastructure.repositories.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apptienda.app_tienda.application.services.IClienteService;
import com.apptienda.app_tienda.domain.entities.Cliente;

@Service
public class ClienteImpl implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Transactional
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    @Override
    public Optional<Cliente> update(Long id, Cliente cliente) {
        Optional<Cliente> clienteOld = clienteRepository.findById(id);
        if(clienteOld.isPresent()) {
            Cliente clienteDb = clienteOld.orElseThrow();

            clienteDb.setNombre(cliente.getNombre());
            clienteDb.setApellido(cliente.getApellido());
            clienteDb.setCelular(cliente.getCelular());
            clienteDb.setDireccion(cliente.getDireccion());
            clienteDb.setCorreoelectronico(cliente.getCorreoelectronico());

            return Optional.of(clienteRepository.save(clienteDb));
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Cliente> delete(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        cliente.ifPresent(clienteDb -> {
            clienteRepository.delete(clienteDb);
        });
        return cliente;
    }
}
