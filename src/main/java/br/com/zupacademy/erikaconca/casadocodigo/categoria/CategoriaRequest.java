package br.com.zupacademy.erikaconca.casadocodigo.categoria;

import br.com.zupacademy.erikaconca.casadocodigo.validadore.ValidarCampoDuplicado;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @ValidarCampoDuplicado(atributo = "nome", aClass = Categoria.class)
    private String nome;

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toCategoria(){
        return new Categoria(this.nome);

    }
}
