package br.com.AulaJPA;

import java.util.ArrayList;
import java.util.List;

import br.com.AulaJPA.repository.AluguelDAO;
import br.com.AulaJPA.repository.ComercioDAO;
import br.com.AulaJPA.repository.AvaliacaoDAO;
import br.com.AulaJPA.repository.ComentarioDAO;
import br.com.AulaJPA.repository.PostDAO;

public class Main3 {
    public static void main(String[] args) {
        // Instanciar DAOs
        AluguelDAO aluguelDAO = new AluguelDAO();
        ComercioDAO comercioDAO = new ComercioDAO();
        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        PostDAO postDAO = new PostDAO();

        // Criar Avaliações
        Avaliacao avaliacao1 = new Avaliacao(null, 4, "Bom apartamento", null, "Residencial", 1L, "url_foto1");
        Avaliacao avaliacao2 = new Avaliacao(null, 5, "Excelente localização", null, "Residencial", 2L, "url_foto2");

        // Criar lista de Avaliações
        List<Avaliacao> avaliacoes = new ArrayList<>();
        avaliacoes.add(avaliacao1);
        avaliacoes.add(avaliacao2);

        // Criar Aluguel com Avaliações
        Aluguel aluguel = new Aluguel(null, "Residencial", "Apartamento de 2 quartos", "imagem_url", "Apartamento no Centro", avaliacoes);

        // Adicionar avaliações ao aluguel
        aluguel.addAvaliacao(avaliacao1);
        aluguel.addAvaliacao(avaliacao2);

        // Salvar Aluguel (com avaliações sendo salvas em cascata)
        aluguelDAO.salvar(aluguel);

        List<Aluguel> alugueis = aluguelDAO.listar();
        for (Aluguel a : alugueis) {
            System.out.println("Aluguel: " + a.getNome() + ", Categoria: " + a.getCategoria());
            for (Avaliacao av : a.getAvaliacoes()) {
                System.out.println(" - Avaliação: " + av.getAvaliacao() + ", Comentário: " + av.getComentario());
            }
        }

        // Exemplo com Comercio
        Comercio comercio = new Comercio(null, "Restaurante", "Restaurante Italiano", "imagem_restaurante", "La Bella", new ArrayList<>());
        
        comercioDAO.salvar(comercio);

        List<Comercio> comercios = comercioDAO.listar();
        for (Comercio c : comercios) {
            System.out.println(c.getNome());
        }

        // Exemplo com Post e Comentario
        Post post = new Post(null, "Primeiro post", "usuario123", new ArrayList<>());
        
        postDAO.salvar(post);

        Comentario comentario = new Comentario(null, post.getId(), "Primeiro comentário", "usuario456", "url_foto");

        comentarioDAO.salvar(comentario);

        List<Post> posts = postDAO.listar();
        for (Post p : posts) {
            System.out.println(p.getDescription());
        }

        List<Comentario> comentarios = comentarioDAO.listar();
        for (Comentario c : comentarios) {
            System.out.println(c.getText());
        }
    }
}
