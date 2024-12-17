package br.com.AulaJPA.repository;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.AulaJPA.Avaliacao;

import java.util.List;

public class AvaliacaoDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");

    public void salvar(Avaliacao avaliacao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(avaliacao);
        em.getTransaction().commit();
        em.close();
    }

    public Avaliacao buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Avaliacao avaliacao = em.find(Avaliacao.class, id);
        em.close();
        return avaliacao;
    }

    public List<Avaliacao> listar() {
        EntityManager em = emf.createEntityManager();
        List<Avaliacao> avaliacoes = em.createQuery("FROM Avaliacao", Avaliacao.class).getResultList();
        em.close();
        return avaliacoes;
    }

    public void atualizar(Avaliacao avaliacao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(avaliacao);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Avaliacao avaliacao = em.find(Avaliacao.class, id);
        if (avaliacao != null) {
            em.remove(avaliacao);
        }
        em.getTransaction().commit();
        em.close();
    }
}
