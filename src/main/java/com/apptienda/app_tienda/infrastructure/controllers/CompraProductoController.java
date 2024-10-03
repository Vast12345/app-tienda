package com.apptienda.app_tienda.infrastructure.controllers;

import com.apptienda.app_tienda.application.services.ICompraProductoService;
import com.apptienda.app_tienda.application.services.ICompraService;
import com.apptienda.app_tienda.application.services.IProductoService;
import com.apptienda.app_tienda.domain.entities.Compra;
import com.apptienda.app_tienda.domain.entities.CompraProducto;
import com.apptienda.app_tienda.domain.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compraproducto")
@CrossOrigin(origins = "http://localhost:3000")
public class CompraProductoController {

    @Autowired
    private ICompraProductoService compraProductoService;
    @Autowired
    private ICompraService compraService;
    @Autowired
    private IProductoService productoService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CompraProducto compraProducto) {
        Compra compra = compraService.findById(compraProducto.getId().getIdcompra()).orElseThrow();
        Producto producto = productoService.findById(compraProducto.getId().getIdproducto()).orElseThrow();

        compraProducto.setCompra(compra);
        compraProducto.setProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(compraProductoService.save(compraProducto));
    }
}
