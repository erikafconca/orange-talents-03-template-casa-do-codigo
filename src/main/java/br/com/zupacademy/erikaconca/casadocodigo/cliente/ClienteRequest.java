package br.com.zupacademy.erikaconca.casadocodigo.cliente;

import br.com.zupacademy.erikaconca.casadocodigo.localizacao.Estado;
import br.com.zupacademy.erikaconca.casadocodigo.localizacao.Pais;
import br.com.zupacademy.erikaconca.casadocodigo.validadore.Grupo;
import br.com.zupacademy.erikaconca.casadocodigo.validadore.ValidarCampoDuplicado;
import br.com.zupacademy.erikaconca.casadocodigo.validadore.ValidarEstado;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

@ValidarEstado
public class ClienteRequest {

    @NotBlank @Email
    @ValidarCampoDuplicado(atributo = "email", aClass = Cliente.class)
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @ValidarCpfCnpj
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = Grupo.Pais.class)
    private Pais pais;

    private Estado estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Pais pais, Estado estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }


    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toCliente(){
        return new Cliente(this.email,this.nome,this.sobrenome,this.documento,
                this.endereco,this.complemento,this.cidade,this.pais, this.estado,
                this.telefone,this.cep);
    }

    @Override
    public String toString() {
        return "ClienteRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
