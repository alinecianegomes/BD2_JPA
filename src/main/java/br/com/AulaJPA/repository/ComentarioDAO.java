package br.com.AulaJPA.repository;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.AulaJPA.Comentario;

import java.util.List;

public class ComentarioDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");

    public void salvar(Comentario comentario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(comentario);
        em.getTransaction().commit();
        em.close();
    }

    public Comentario buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Comentario comentario = em.find(Comentario.class, id);
        em.close();
        return comentario;
    }

    public List<Comentario> listar() {
        EntityManager em = emf.createEntityManager();
        List<Comentario> comentarios = em.createQuery("FROM Comentario", Comentario.class).getResultList();
        em.close();
        return comentarios;
    }

    public void atualizar(Comentario comentario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(comentario);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Comentario comentario = em.find(Comentario.class, id);
        if (comentario != null) {
            em.remove(comentario);
        }
        em.getTransaction().commit();
        em.close();
    }
}

