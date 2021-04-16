package br.com.zupacademy.erikaconca.casadocodigo.localizacao;

import br.com.zupacademy.erikaconca.casadocodigo.validadore.Grupo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Grupo.Pais.class)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    public Pais() {
    }

    @JsonCreator
    public Pais(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
