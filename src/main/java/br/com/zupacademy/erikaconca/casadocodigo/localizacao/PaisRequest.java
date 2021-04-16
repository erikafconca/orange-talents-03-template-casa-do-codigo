package br.com.zupacademy.erikaconca.casadocodigo.localizacao;

import com.example.demo.validadores.ValidarCamposDuplicados;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @ValidarCamposDuplicados(atributo = "nome", aClass = Pais.class)
    private String nome;

    @JsonCreator
    public PaisRequest(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais toPais(){
        return new Pais(this.nome);
    }
}
