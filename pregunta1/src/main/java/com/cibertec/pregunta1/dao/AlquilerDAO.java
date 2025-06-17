package com.cibertec.pregunta1.dao;

import com.cibertec.pregunta1.model.Alquiler;
import jakarta.persistence.*;

public class AlquilerDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2_ApellidoPU");

    public void insertar(Alquiler alquiler) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(alquiler); // <- evita el error de detached entity
    em.getTransaction().commit();
    em.close();
}

    public Alquiler buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Alquiler alquiler = em.find(Alquiler.class, id);
        em.close();
        return alquiler;
    }

    public void actualizar(Alquiler alquiler) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(alquiler);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        Alquiler alquiler = em.find(Alquiler.class, id);
        if (alquiler != null) {
            em.getTransaction().begin();
            em.remove(alquiler);
            em.getTransaction().commit();
        }
        em.close();
    }
}
