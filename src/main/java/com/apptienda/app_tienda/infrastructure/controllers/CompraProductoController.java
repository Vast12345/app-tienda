package com.apptienda.app_tienda.infrastructure.controllers;

import com.apptienda.app_tienda.application.services.ICompraProductoService;
import com.apptienda.app_tienda.domain.entities.CompraProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compraproducto")
@CrossOrigin(origins = "http://localhost:3000")
public class CompraProductoController {

    @Autowired
    private ICompraProductoService compraProductoService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CompraProducto compraProducto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(compraProductoService.save(compraProducto));
    }
}
