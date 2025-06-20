package com.blockbuster.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetalleAlquilerId implements Serializable {

    private Long idAlquiler;
    private Long idPelicula;

    public DetalleAlquilerId() {}

    public DetalleAlquilerId(Long idAlquiler, Long idPelicula) {
        this.idAlquiler = idAlquiler;
        this.idPelicula = idPelicula;
    }

    // getters y setters
}
