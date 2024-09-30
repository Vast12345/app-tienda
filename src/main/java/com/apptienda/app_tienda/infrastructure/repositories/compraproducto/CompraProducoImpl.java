package com.apptienda.app_tienda.infrastructure.repositories.compraproducto;

import com.apptienda.app_tienda.application.services.ICompraProductoService;
import com.apptienda.app_tienda.domain.entities.CompraProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraProducoImpl implements ICompraProductoService {

    @Autowired
    private ICompraProductoRepository compraProductoRepository;
    @Override
    public CompraProducto save(CompraProducto compraProducto) {
        return compraProductoRepository.save(compraProducto);
    }
}
