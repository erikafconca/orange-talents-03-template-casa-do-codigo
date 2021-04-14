package br.com.zupacademy.erikaconca.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    private String nome;

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
