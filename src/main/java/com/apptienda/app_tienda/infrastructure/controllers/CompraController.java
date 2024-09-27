package com.apptienda.app_tienda.infrastructure.controllers;

import com.apptienda.app_tienda.application.services.ICompraService;
import com.apptienda.app_tienda.domain.entities.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compra")
@CrossOrigin(origins = "http://localhost:3000")
public class CompraController {

    @Autowired
    private ICompraService compraService;

    @GetMapping("/list")
    public List<Compra> list() {
        return compraService.findAll();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Compra> compraOptional = compraService.findById(id);
        if(compraOptional.isPresent()) {
            return ResponseEntity.ok(compraOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Compra compra) {
        return ResponseEntity.status(HttpStatus.CREATED).body(compraService.save(compra));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Compra compra, @PathVariable Long id) {
        Optional<Compra> compraOptional = compraService.update(id, compra);
        if(compraOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(compraOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Compra> compraOptional = compraService.delete(id);
        if(compraOptional.isPresent()) {
            return ResponseEntity.ok(compraOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
