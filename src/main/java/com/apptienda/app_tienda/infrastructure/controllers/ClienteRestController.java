package com.apptienda.app_tienda.infrastructure.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.apptienda.app_tienda.application.services.IClienteService;
import com.apptienda.app_tienda.domain.entities.Cliente;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/list")
    public List<Cliente> list() {
        return clienteService.findAll();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, @PathVariable Long id, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<Cliente> clienteOptional = clienteService.update(id, cliente);
        if(clienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.delete(id);
        if(clienteOptional.isPresent()) {
            return ResponseEntity.ok(clienteOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }   

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach((err) -> {
            errors.put(err.getField(), "The Field" + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
