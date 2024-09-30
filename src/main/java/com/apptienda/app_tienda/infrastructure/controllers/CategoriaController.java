package com.apptienda.app_tienda.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apptienda.app_tienda.application.services.ICategoriaService;
import com.apptienda.app_tienda.domain.entities.Categoria;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/list")
    public List<Categoria> list() {
        return categoriaService.findAll();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if(categoriaOptional.isPresent()) {
            return ResponseEntity.ok(categoriaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Categoria categoria, @PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.update(id, categoria);
        if(categoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.delete(id);
        if(categoriaOptional.isPresent()) {
            return ResponseEntity.ok(categoriaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
