package com.blockbuster.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalle_alquiler")
public class DetalleAlquiler {

    @EmbeddedId
    private DetalleAlquilerId id;

    @ManyToOne
    @MapsId("idAlquiler")
    @JoinColumn(name = "id_alquiler")
    private Alquiler alquiler;

    @ManyToOne
    @MapsId("idPelicula")
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad mínima debe ser 1")
    private int cantidad;

    // Getters y Setters

    public DetalleAlquilerId getId() {
        return id;
    }

    public void setId(DetalleAlquilerId id) {
        this.id = id;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
