package com.blockbuster.controller;

import com.blockbuster.model.Cliente;
import com.blockbuster.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente_form";
    }

    @PostMapping("/guardar")
    public String guardarCliente(@Valid @ModelAttribute Cliente cliente,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            return "cliente_form";
        }

        clienteRepository.save(cliente);
        model.addAttribute("mensaje", "Cliente registrado con éxito");
        return "cliente_form";
    }
}

