package com.apptienda.app_tienda.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apptienda.app_tienda.application.services.IClienteService;
import com.apptienda.app_tienda.domain.entities.Cliente;

@Controller
@RequestMapping("/cliente") 
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/list")
    public String list(ModelMap model) {
        List<Cliente> clientes = clienteService.findAll();

        model.addAttribute("clientes", clientes);
        return "clientelist";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if(cliente.isPresent()) {
            model.addAttribute("cliente", cliente);
            return "clienteview";
        }
        return "clienteview";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Cliente cliente, Model model) {
        clienteService.save(cliente);
        model.addAttribute("message", cliente);
        return "clientecreate";
    }

    @PutMapping("/update/{id}")
    public String update(@ModelAttribute Cliente cliente, @PathVariable Long id, Model model) {
        Optional<Cliente> clienteOptional = clienteService.update(id, cliente);

        model.addAttribute("cliente", clienteOptional);
        return "clienteupdate";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        Optional<Cliente> clienteOptional = clienteService.delete(id);

        model.addAttribute("cliente", clienteOptional);
        return "clientedelete";
    }
}
