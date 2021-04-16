package br.com.zupacademy.erikaconca.casadocodigo.localizacao;

import com.example.demo.validadores.Grupo;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

public class EstadoRequest {

    @NotBlank
    private String nome;
    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = Grupo.Pais.class)
    private Pais pais;

    public EstadoRequest(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado toEstado(){
        return new Estado(this.nome, this.pais);
    }

}
