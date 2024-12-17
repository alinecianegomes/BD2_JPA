package br.com.AulaJPA.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.AulaJPA.Comercio;

import java.util.List;

public class ComercioDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");

    public void salvar(Comercio comercio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(comercio);
        em.getTransaction().commit();
        em.close();
    }

    public Comercio buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Comercio comercio = em.find(Comercio.class, id);
        em.close();
        return comercio;
    }

    public List<Comercio> listar() {
        EntityManager em = emf.createEntityManager();
        List<Comercio> comercios = em.createQuery("FROM Comercio", Comercio.class).getResultList();
        em.close();
        return comercios;
    }

    public void atualizar(Comercio comercio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(comercio);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Comercio comercio = em.find(Comercio.class, id);
        if (comercio != null) {
            em.remove(comercio);
        }
        em.getTransaction().commit();
        em.close();
    }
}
