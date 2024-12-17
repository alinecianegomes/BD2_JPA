package br.com.AulaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Unidades de Persistência
        EntityManagerFactory emfComercio = Persistence.createEntityManagerFactory("comercio-unit");
        EntityManager emComercio = emfComercio.createEntityManager();

        EntityManagerFactory emfServico = Persistence.createEntityManagerFactory("servico-unit");
        EntityManager emServico = emfServico.createEntityManager();

        EntityManagerFactory emfAluguel = Persistence.createEntityManagerFactory("aluguel-unit");
        EntityManager emAluguel = emfAluguel.createEntityManager();

        EntityManagerFactory emfPost = Persistence.createEntityManagerFactory("post-unit");
        EntityManager emPost = emfPost.createEntityManager();

        // Criar Aluguel
        emAluguel.getTransaction().begin();
        Aluguel aluguel = new Aluguel();
        aluguel.setCategoria("Residencial");
        aluguel.setDescricao("Apartamento de 2 quartos");
        aluguel.setImagem("imagem_url");
        aluguel.setNome("Apartamento no Centro");
        emAluguel.persist(aluguel);
        emAluguel.getTransaction().commit();

        // Criar Avaliações para o Aluguel
        emAluguel.getTransaction().begin();
        Avaliacao avaliacaoAluguel1 = new Avaliacao();
        avaliacaoAluguel1.setAvaliacao(4);
        avaliacaoAluguel1.setComentario("Bom apartamento");
        avaliacaoAluguel1.setUsuarioId(1L);
        avaliacaoAluguel1.setUserphoto("url_foto1");
        avaliacaoAluguel1.setAluguel(aluguel);
        emAluguel.persist(avaliacaoAluguel1);

        Avaliacao avaliacaoAluguel2 = new Avaliacao();
        avaliacaoAluguel2.setAvaliacao(5);
        avaliacaoAluguel2.setComentario("Excelente localização");
        avaliacaoAluguel2.setUsuarioId(2L);
        avaliacaoAluguel2.setUserphoto("url_foto2");
        avaliacaoAluguel2.setAluguel(aluguel);
        emAluguel.persist(avaliacaoAluguel2);
        emAluguel.getTransaction().commit();

        // Criar Comercio e suas Avaliações
        emComercio.getTransaction().begin();
        Avaliacao avaliacaoComercio1 = new Avaliacao();
        avaliacaoComercio1.setAvaliacao(4);
        avaliacaoComercio1.setComentario("Ótimo restaurante");
        avaliacaoComercio1.setUsuarioId(3L);
        avaliacaoComercio1.setUserphoto("url_foto3");
        emComercio.persist(avaliacaoComercio1);

        Avaliacao avaliacaoComercio2 = new Avaliacao();
        avaliacaoComercio2.setAvaliacao(5);
        avaliacaoComercio2.setComentario("Comida deliciosa");
        avaliacaoComercio2.setUsuarioId(4L);
        avaliacaoComercio2.setUserphoto("url_foto4");
        emComercio.persist(avaliacaoComercio2);

        Comercio comercio = new Comercio();
        comercio.setCategoria("Restaurante");
        comercio.setDescricao("Restaurante Italiano");
        comercio.setImagem("imagem_restaurante");
        comercio.setNome("La Bella");
        comercio.addAvaliacao(avaliacaoComercio1); // Adicionar avaliação ao comercio
        comercio.addAvaliacao(avaliacaoComercio2); // Adicionar avaliação ao comercio
        emComercio.persist(comercio);
        emComercio.getTransaction().commit();

        // Criar Servico e suas Avaliações
        emServico.getTransaction().begin();
        Avaliacao avaliacaoServico1 = new Avaliacao();
        avaliacaoServico1.setAvaliacao(4);
        avaliacaoServico1.setComentario("Bom serviço de limpeza");
        avaliacaoServico1.setUsuarioId(5L);
        avaliacaoServico1.setUserphoto("url_foto5");
        emServico.persist(avaliacaoServico1);

        Avaliacao avaliacaoServico2 = new Avaliacao();
        avaliacaoServico2.setAvaliacao(5);
        avaliacaoServico2.setComentario("Equipe eficiente");
        avaliacaoServico2.setUsuarioId(6L);
        avaliacaoServico2.setUserphoto("url_foto6");
        emServico.persist(avaliacaoServico2);

        Servico servico = new Servico();
        servico.setCategoria("Limpeza");
        servico.setDescricao("Serviço de limpeza residencial");
        servico.setImagem("imagem_servico");
        servico.setNome("Limpa Fácil");
        servico.addAvaliacao(avaliacaoServico1); // Adicionar avaliação ao serviço
        servico.addAvaliacao(avaliacaoServico2); // Adicionar avaliação ao serviço
        emServico.persist(servico);
        emServico.getTransaction().commit();

        // Criar Post
        emPost.getTransaction().begin();
        Post post = new Post();
        post.setDescription("Primeiro post");
        post.setUsuario("usuario123");
        emPost.persist(post);
        emPost.getTransaction().commit();

        // Criar Comentário para o Post
        emPost.getTransaction().begin();
        Comentario comentario = new Comentario();
        comentario.setPostID(post.getId());
        comentario.setText("Primeiro comentário");
        comentario.setUsuario("usuario456");
        comentario.setUserPhoto("url_foto");
        comentario.setPost(post);
        emPost.persist(comentario);
        post.addComentario(comentario);  // Adicionar o comentário ao post
        emPost.getTransaction().commit();

        // Buscar Aluguel e Avaliações
        Aluguel aluguelBuscado = emAluguel.find(Aluguel.class, aluguel.getId());
        System.out.println("Aluguel: " + aluguelBuscado.getNome() + ", Categoria: " + aluguelBuscado.getCategoria());
        for (Avaliacao av : aluguelBuscado.getAvaliacoes()) {
            System.out.println(" - Avaliação: " + av.getAvaliacao() + ", Comentário: " + av.getComentario());
        }

        // Buscar Comercio e Avaliações
        Comercio comercioBuscado = emComercio.find(Comercio.class, comercio.getId());
        System.out.println("Comercio: " + comercioBuscado.getNome() + ", Categoria: " + comercioBuscado.getCategoria());
        for (Avaliacao av : comercioBuscado.getAvaliacoes()) {
            System.out.println(" - Avaliação: " + av.getAvaliacao() + ", Comentário: " + av.getComentario());
        }

        // Buscar Servico e Avaliações
        Servico servicoBuscado = emServico.find(Servico.class, servico.getId());
        System.out.println("Serviço: " + servicoBuscado.getNome() + ", Categoria: " + servicoBuscado.getCategoria());
        for (Avaliacao av : servicoBuscado.getAvaliacoes()) {
            System.out.println(" - Avaliação: " + av.getAvaliacao() + ", Comentário: " + av.getComentario());
        }

        // Buscar Post e Comentários
        Post postBuscado = emPost.find(Post.class, post.getId());
        System.out.println("Post: " + postBuscado.getDescription());
        for (Comentario com : postBuscado.getComentarios()) {
            System.out.println(" - Comentário: " + com.getText() + ", Usuário: " + com.getUsuario());
        }

        // Fechar EntityManagers e EntityManagerFactories
        emComercio.close();
        emfComercio.close();

        emServico.close();
        emfServico.close();

        emAluguel.close();
        emfAluguel.close();

        emPost.close();
        emfPost.close();
    }
}
