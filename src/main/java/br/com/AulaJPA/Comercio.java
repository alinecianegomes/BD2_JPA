package br.com.AulaJPA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, length = 100)    
    private String categoria;
    
    @NotNull
    @Column(nullable = false, length = 500)
    private String descricao;
    private String imagem;
    
    @NotNull
    @Column(nullable = false, length = 200)
    private String nome;

    @OneToMany(mappedBy = "comercio", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;

    // Construtores, getters e setters
    public Comercio() {
        this.avaliacoes = new ArrayList<>();
    }

    public Comercio(Long id, String categoria, String descricao, String imagem, String nome, List<Avaliacao> avaliacoes) {
        this.id = id;
        this.categoria = categoria;
        this.descricao = descricao;
        this.imagem = imagem;
        this.nome = nome;
        this.avaliacoes = avaliacoes != null ? avaliacoes : new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void addAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
        avaliacao.setComercio(this);
    }
}
