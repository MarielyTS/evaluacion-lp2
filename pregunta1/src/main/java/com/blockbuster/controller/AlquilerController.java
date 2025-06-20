package com.blockbuster.controller;

import com.blockbuster.model.Alquiler;
import com.blockbuster.model.EstadoAlquiler;
import com.blockbuster.repository.AlquilerRepository;
import com.blockbuster.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alquileres")
public class AlquilerController {

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String listarAlquileres(Model model) {
        model.addAttribute("alquileres", alquilerRepository.findAll());
        return "alquiler_lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("alquiler", new Alquiler());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("estados", EstadoAlquiler.values());
        return "alquiler_form";
    }

    @PostMapping("/guardar")
    public String guardarAlquiler(@Valid @ModelAttribute Alquiler alquiler,
            BindingResult result,
            @RequestParam("cliente.idCliente") Long idCliente,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clientes", clienteRepository.findAll());
            model.addAttribute("estados", EstadoAlquiler.values());
            return "alquiler_form";
        }

        // ✅ Solución: buscar el cliente completo
        alquiler.setCliente(clienteRepository.findById(idCliente).orElse(null));

        alquilerRepository.save(alquiler);
        return "redirect:/alquileres";
    }

    @GetMapping("/editar/{id}")
    public String editarAlquiler(@PathVariable("id") Long id, Model model) {
        Alquiler alquiler = alquilerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("alquiler", alquiler);
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("estados", EstadoAlquiler.values());
        return "alquiler_form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAlquiler(@PathVariable("id") Long id) {
        Alquiler alquiler = alquilerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        alquilerRepository.delete(alquiler);
        return "redirect:/alquileres";
    }
}
