package com.cibertec;

import com.cibertec.pregunta1.dao.*;
import com.cibertec.pregunta1.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        // Paso 1: Iniciar mensaje para representar "inicio del servidor"
        System.out.println("Iniciando conexión a la base de datos BD2_Apellido...");

        // Paso 2: Pausa para simular inspección de base de datos
        System.out.println("Esperando 10 segundos para inspección de BD...");
        Thread.sleep(10000); // pausa de 10 segundos

        // Paso 3: Ejecutar operaciones CRUD

        ClienteDAO clienteDAO = new ClienteDAO();
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        AlquilerDAO alquilerDAO = new AlquilerDAO();
        DetalleAlquilerDAO detalleDAO = new DetalleAlquilerDAO();

        // Crear cliente
        Cliente cliente = new Cliente();
        cliente.setIdCliente(10);
        cliente.setNombre("Pedro Casas");
        cliente.setEmail("pedro@example.com");
        clienteDAO.insertar(cliente);

        // Crear película
        Pelicula peli = new Pelicula();
        peli.setIdPelicula(20);
        peli.setTitulo("Matrix");
        peli.setGenero("Acción");
        peli.setStock(4);
        peliculaDAO.insertar(peli);

        // Crear alquiler
        Alquiler alquiler = new Alquiler();
        alquiler.setCliente(cliente);
        alquiler.setFecha(LocalDate.now());
        alquiler.setTotal(new BigDecimal("25.00"));
        alquiler.setEstado(EstadoAlquiler.Activo);
        alquilerDAO.insertar(alquiler);

        // Crear detalle de alquiler
        DetalleAlquiler detalle = new DetalleAlquiler();
        DetalleAlquiler.DetalleAlquilerId id = new DetalleAlquiler.DetalleAlquilerId(
                alquiler.getIdAlquiler(), peli.getIdPelicula());
        detalle.setId(id);
        detalle.setCantidad(1);
        detalle.setAlquiler(alquiler);
        detalle.setPelicula(peli);
        detalleDAO.insertar(detalle);

        System.out.println("Operaciones CRUD completadas correctamente.");
    }
}
