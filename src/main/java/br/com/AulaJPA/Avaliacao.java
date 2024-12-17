package br.com.AulaJPA;

import javax.persistence.*;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int avaliacao;
    private String comentario;
    private Long itemid;
    private String tipoItem;
    private Long usuarioId;
    private String userphoto;

    @ManyToOne
    private Aluguel aluguel;

    @ManyToOne
    private Comercio comercio;

    @ManyToOne
    private Servico servico;

    // Construtores, getters e setters
    public Avaliacao(Long id, int avaliacao, String comentario, Long itemid, String tipoItem, Long usuarioId, String userphoto) {
        this.id = id;
        this.avaliacao = avaliacao;
        this.comentario = comentario;
        this.itemid = itemid;
        this.tipoItem = tipoItem;
        this.usuarioId = usuarioId;
        this.userphoto = userphoto;
    }

    public Avaliacao() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
