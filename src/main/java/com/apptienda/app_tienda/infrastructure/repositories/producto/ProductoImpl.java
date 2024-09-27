package com.apptienda.app_tienda.infrastructure.repositories.producto;

import com.apptienda.app_tienda.application.services.IProductoService;
import com.apptienda.app_tienda.domain.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoImpl implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Transactional
    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> update(Long id, Producto producto) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if(productoOptional.isPresent()) {
            Producto productoDb = productoOptional.orElseThrow();

            productoDb.setNombre(producto.getNombre());
            productoDb.setCodigobarras(producto.getCodigobarras());
            productoDb.setPrecioventa(producto.getPrecioventa());
            productoDb.setCantidadstock(producto.getCantidadstock());
            productoDb.setEstado(producto.isEstado());

            return Optional.of(productoRepository.save(productoDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Producto> delete(Long id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        productoOptional.ifPresent(productoDb -> {
            productoRepository.delete(productoDb);
        });
        return productoOptional;
    }
}
