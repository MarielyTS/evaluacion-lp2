package com.cibertec.pregunta1.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlquiler;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    private Cliente cliente;

    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private EstadoAlquiler estado;

    // Getters y Setters
    public int getIdAlquiler() {
    return idAlquiler;
}

public void setIdAlquiler(int idAlquiler) {
    this.idAlquiler = idAlquiler;
}

public LocalDate getFecha() {
    return fecha;
}

public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
}

public Cliente getCliente() {
    return cliente;
}

public void setCliente(Cliente cliente) {
    this.cliente = cliente;
}

public BigDecimal getTotal() {
    return total;
}

public void setTotal(BigDecimal total) {
    this.total = total;
}

public EstadoAlquiler getEstado() {
    return estado;
}

public void setEstado(EstadoAlquiler estado) {
    this.estado = estado;
}

}
