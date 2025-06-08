package com.cibertec.pregunta1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pelicula {
    @Id
    private int idPelicula;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String genero;

    private int stock;

    // Getters y Setters
    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return titulo; // o puedes mostrar más: return idPelicula + " - " + titulo;
    }

}
