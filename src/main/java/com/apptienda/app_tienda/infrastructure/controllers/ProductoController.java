package com.apptienda.app_tienda.infrastructure.controllers;

import com.apptienda.app_tienda.application.services.IProductoService;
import com.apptienda.app_tienda.domain.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/list")
    public List<Producto> list() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.findById(id);
        if(productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.update(id, producto);
        if(productoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.delete(id);
        if(productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
