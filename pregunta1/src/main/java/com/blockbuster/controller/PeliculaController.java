package com.blockbuster.controller;

import com.blockbuster.model.Pelicula;
import com.blockbuster.repository.PeliculaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "pelicula_form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Pelicula pelicula,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "pelicula_form";
        }

        peliculaRepository.save(pelicula);
        return "redirect:/peliculas"; // <- Asegúrate de redirigir aquí
    }

    @GetMapping
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaRepository.findAll());
        return "pelicula_lista";
    }

    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable("id") Long id, Model model) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("pelicula", pelicula);
        return "pelicula_form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable("id") Long id) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        peliculaRepository.delete(pelicula);
        return "redirect:/peliculas";
    }

}
