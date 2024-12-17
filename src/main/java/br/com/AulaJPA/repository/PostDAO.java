package br.com.AulaJPA.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.AulaJPA.Post;

import java.util.List;

public class PostDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud-basic");

    public void salvar(Post post) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(post);
        em.getTransaction().commit();
        em.close();
    }

    public Post buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Post post = em.find(Post.class, id);
        em.close();
        return post;
    }

    public List<Post> listar() {
        EntityManager em = emf.createEntityManager();
        List<Post> posts = em.createQuery("FROM Post", Post.class).getResultList();
        em.close();
        return posts;
    }

    public void atualizar(Post post) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(post);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Post post = em.find(Post.class, id);
        if (post != null) {
            em.remove(post);
        }
        em.getTransaction().commit();
        em.close();
    }
}
