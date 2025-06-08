package com.cibertec.pregunta1.dao;

import com.cibertec.pregunta1.model.DetalleAlquiler;
import com.cibertec.pregunta1.model.DetalleAlquiler.DetalleAlquilerId;

import jakarta.persistence.*;

public class DetalleAlquilerDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2_ApellidoPU");

    public void insertar(DetalleAlquiler detalle) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(detalle);
        em.getTransaction().commit();
        em.close();
    }

    public DetalleAlquiler buscarPorId(DetalleAlquilerId id) {
        EntityManager em = emf.createEntityManager();
        DetalleAlquiler detalle = em.find(DetalleAlquiler.class, id);
        em.close();
        return detalle;
    }

    public void actualizar(DetalleAlquiler detalle) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(detalle);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(DetalleAlquilerId id) {
        EntityManager em = emf.createEntityManager();
        DetalleAlquiler detalle = em.find(DetalleAlquiler.class, id);
        if (detalle != null) {
            em.getTransaction().begin();
            em.remove(detalle);
            em.getTransaction().commit();
        }
        em.close();
    }
}
