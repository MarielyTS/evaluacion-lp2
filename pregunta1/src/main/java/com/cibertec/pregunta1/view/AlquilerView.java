package com.cibertec.pregunta1.view;

import com.cibertec.pregunta1.dao.*;
import com.cibertec.pregunta1.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AlquilerView extends JFrame {
    private JComboBox<Cliente> comboClientes;
    private JComboBox<Pelicula> comboPeliculas;
    private JTextField txtCantidad;
    private JLabel lblTotal;
    private JButton btnRegistrar;

    private ClienteDAO clienteDAO = new ClienteDAO();
    private PeliculaDAO peliculaDAO = new PeliculaDAO();
    private AlquilerDAO alquilerDAO = new AlquilerDAO();
    private DetalleAlquilerDAO detalleDAO = new DetalleAlquilerDAO();

    public AlquilerView() {
        setTitle("Gestión de Alquiler");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        comboClientes = new JComboBox<>();
        comboPeliculas = new JComboBox<>();
        txtCantidad = new JTextField();
        lblTotal = new JLabel("Total: S/ 0.00");
        btnRegistrar = new JButton("Registrar Alquiler");

        add(new JLabel("Cliente:"));
        add(comboClientes);
        add(new JLabel("Película:"));
        add(comboPeliculas);
        add(new JLabel("Cantidad:"));
        add(txtCantidad);
        add(new JLabel(""));
        add(lblTotal);
        add(new JLabel(""));
        add(btnRegistrar);

        cargarCombos();

        txtCantidad.addActionListener(e -> calcularTotal());
        btnRegistrar.addActionListener(this::registrarAlquiler);

        setVisible(true);
    }

    private void cargarCombos() {
        List<Cliente> clientes = clienteDAO.listarTodos();
        for (Cliente c : clientes) comboClientes.addItem(c);

        List<Pelicula> peliculas = peliculaDAO.listarTodos();
        for (Pelicula p : peliculas) comboPeliculas.addItem(p);
    }

    private void calcularTotal() {
        try {
            int cantidad = Integer.parseInt(txtCantidad.getText());
            BigDecimal precio = new BigDecimal("10.00"); // Precio fijo
            BigDecimal total = precio.multiply(new BigDecimal(cantidad));
            lblTotal.setText("Total: S/ " + total);
        } catch (NumberFormatException e) {
            lblTotal.setText("Total: S/ 0.00");
        }
    }

    private void registrarAlquiler(ActionEvent e) {
        try {
            Cliente cliente = (Cliente) comboClientes.getSelectedItem();
            Pelicula pelicula = (Pelicula) comboPeliculas.getSelectedItem();
            int cantidad = Integer.parseInt(txtCantidad.getText());

            BigDecimal total = new BigDecimal("10.00").multiply(new BigDecimal(cantidad));

            Alquiler alquiler = new Alquiler();
            alquiler.setCliente(cliente);
            alquiler.setFecha(LocalDate.now());
            alquiler.setEstado(EstadoAlquiler.Activo);
            alquiler.setTotal(total);
            alquilerDAO.insertar(alquiler);

            DetalleAlquiler detalle = new DetalleAlquiler();
            DetalleAlquiler.DetalleAlquilerId id = new DetalleAlquiler.DetalleAlquilerId(
                    alquiler.getIdAlquiler(), pelicula.getIdPelicula());
            detalle.setId(id);
            detalle.setCantidad(cantidad);
            detalle.setAlquiler(alquiler);
            detalle.setPelicula(pelicula);
            detalleDAO.insertar(detalle);

            JOptionPane.showMessageDialog(this, "Alquiler registrado con éxito");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AlquilerView::new);
    }
}
