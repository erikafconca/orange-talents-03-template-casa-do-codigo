package br.com.zupacademy.erikaconca.casadocodigo.autor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 400)
    private String descricao;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}