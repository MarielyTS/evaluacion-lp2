package com.blockbuster.controller;

import com.blockbuster.model.*;
import com.blockbuster.repository.*;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalle-alquiler")
public class DetalleAlquilerController {

    @Autowired
    private DetalleAlquilerRepository detalleAlquilerRepository;

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("detalleAlquiler", new DetalleAlquiler());
        model.addAttribute("alquileres", alquilerRepository.findAll());
        model.addAttribute("peliculas", peliculaRepository.findAll());
        return "detalle_form";
    }

    @PostMapping("/guardar")
    public String guardarDetalle(@Valid @ModelAttribute DetalleAlquiler detalleAlquiler,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("alquileres", alquilerRepository.findAll());
            model.addAttribute("peliculas", peliculaRepository.findAll());
            return "detalle_form";
        }

        // Configurar la clave compuesta manualmente
        DetalleAlquilerId id = new DetalleAlquilerId(
                detalleAlquiler.getAlquiler().getIdAlquiler(),
                detalleAlquiler.getPelicula().getIdPelicula()
        );
        detalleAlquiler.setId(id);

        detalleAlquilerRepository.save(detalleAlquiler);
        return "redirect:/detalle-alquiler/nuevo?success";
    }
}
