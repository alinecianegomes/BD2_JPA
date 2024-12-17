package br.com.AulaJPA;

import javax.persistence.*;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postID;
    private String text;
    private String usuario; 
    private String userPhoto;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

   
    public Comentario(Long id, Long postID, String text, String usuario, String userPhoto) {
        this.id = id;
        this.postID = postID;
        this.text = text;
        this.usuario = usuario;
        this.userPhoto = userPhoto;
    }

    public Comentario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
