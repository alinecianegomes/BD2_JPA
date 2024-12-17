package br.com.AulaJPA.repository;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.AulaJPA.Aluguel;

import java.util.List;

public class AluguelDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");

    public void salvar(Aluguel aluguel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(aluguel);
        em.getTransaction().commit();
        em.close();
    }

    public Aluguel buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Aluguel aluguel = em.find(Aluguel.class, id);
        em.close();
        return aluguel;
    }

    public List<Aluguel> listar() {
        EntityManager em = emf.createEntityManager();
        List<Aluguel> alugueis = em.createQuery("FROM Aluguel", Aluguel.class).getResultList();
        em.close();
        return alugueis;
    }

    public void atualizar(Aluguel aluguel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(aluguel);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Aluguel aluguel = em.find(Aluguel.class, id);
        if (aluguel != null) {
            em.remove(aluguel);
        }
        em.getTransaction().commit();
        em.close();
    }
}

