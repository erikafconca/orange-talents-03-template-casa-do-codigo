package br.com.zupacademy.erikaconca.casadocodigo.categoria;

import br.com.zupacademy.erikaconca.casadocodigo.validadore.Grupo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

    @NotNull(groups = Grupo.Categoria.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;

    public Categoria() {
    }

    @JsonCreator
    public Categoria(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
