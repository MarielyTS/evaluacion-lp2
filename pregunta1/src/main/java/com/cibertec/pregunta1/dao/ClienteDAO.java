package com.cibertec.pregunta1.dao;

import com.cibertec.pregunta1.model.Cliente;
import jakarta.persistence.*;

public class ClienteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2_ApellidoPU");

    public void insertar(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public Cliente buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }

    public void actualizar(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        }
        em.close();
    }
        public java.util.List<Cliente> listarTodos() {
        EntityManager em = emf.createEntityManager();
        java.util.List<Cliente> lista = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        em.close();
        return lista;
    }
}

