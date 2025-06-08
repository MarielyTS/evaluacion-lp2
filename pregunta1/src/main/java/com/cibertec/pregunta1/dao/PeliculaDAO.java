package com.cibertec.pregunta1.dao;

import com.cibertec.pregunta1.model.Pelicula;
import jakarta.persistence.*;

public class PeliculaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2_ApellidoPU");

    public void insertar(Pelicula pelicula) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pelicula);
        em.getTransaction().commit();
        em.close();
    }

    public Pelicula buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Pelicula pelicula = em.find(Pelicula.class, id);
        em.close();
        return pelicula;
    }

    public void actualizar(Pelicula pelicula) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pelicula);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        Pelicula pelicula = em.find(Pelicula.class, id);
        if (pelicula != null) {
            em.getTransaction().begin();
            em.remove(pelicula);
            em.getTransaction().commit();
        }
        em.close();
    }
        public java.util.List<Pelicula> listarTodos() {
        EntityManager em = emf.createEntityManager();
        java.util.List<Pelicula> lista = em.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
        em.close();
        return lista;
    }

}

