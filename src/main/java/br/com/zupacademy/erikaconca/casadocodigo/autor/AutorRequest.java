package br.com.zupacademy.erikaconca.casadocodigo.autor;

import br.com.zupacademy.erikaconca.casadocodigo.validadore.ValidarCampoDuplicado;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;
    @NotBlank @Email
    @ValidarCampoDuplicado(atributo = "email", aClass = Autor.class)
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    public Autor toAutor(){
        Autor autor = new Autor(nome, email, descricao);
        return autor;
    }
}
