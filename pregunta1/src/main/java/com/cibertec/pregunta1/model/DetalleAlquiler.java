package com.cibertec.pregunta1.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class DetalleAlquiler {

    @EmbeddedId
    private DetalleAlquilerId id;

    private int cantidad;

    @ManyToOne
    @MapsId("idAlquiler")
    private Alquiler alquiler;

    @ManyToOne
    @MapsId("idPelicula")
    private Pelicula pelicula;

    // Getters, Setters
    public DetalleAlquilerId getId() {
    return id;
}

public void setId(DetalleAlquilerId id) {
    this.id = id;
}

public int getCantidad() {
    return cantidad;
}

public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
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

    
    
    @Embeddable
    public static class DetalleAlquilerId implements Serializable {
        private int idAlquiler;
        private int idPelicula;

        // Constructor vacío obligatorio
        public DetalleAlquilerId() {}

        // Constructor con parámetros (opcional)
        public DetalleAlquilerId(int idAlquiler, int idPelicula) {
            this.idAlquiler = idAlquiler;
            this.idPelicula = idPelicula;
        }

        // Getters y Setters
        public int getIdAlquiler() {
    return idAlquiler;
}

public void setIdAlquiler(int idAlquiler) {
    this.idAlquiler = idAlquiler;
}

public int getIdPelicula() {
    return idPelicula;
}

public void setIdPelicula(int idPelicula) {
    this.idPelicula = idPelicula;
}


        // equals() y hashCode()
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DetalleAlquilerId that = (DetalleAlquilerId) o;
            return idAlquiler == that.idAlquiler &&
                   idPelicula == that.idPelicula;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idAlquiler, idPelicula);
        }
    }
}
