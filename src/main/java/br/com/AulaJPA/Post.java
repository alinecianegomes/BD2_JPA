package br.com.AulaJPA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String usuario;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    
    public Post() {
        this.comentarios = new ArrayList<>();  
    }

    public Post(Long id, String description, String usuario, List<Comentario> comentarios) {
        this.id = id;
        this.description = description;
        this.usuario = usuario;
        this.comentarios = comentarios != null ? comentarios : new ArrayList<>();  // Inicializa a lista se estiver nula
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
        comentario.setPost(this);
    }
}
