package br.com.zupacademy.erikaconca.casadocodigo.livro;

import br.com.zupacademy.erikaconca.casadocodigo.autor.Autor;
import br.com.zupacademy.erikaconca.casadocodigo.categoria.Categoria;
import br.com.zupacademy.erikaconca.casadocodigo.validadore.Grupo;
import br.com.zupacademy.erikaconca.casadocodigo.validadore.ValidarCampoDuplicado;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {
    @NotBlank @ValidarCampoDuplicado(atributo = "titulo", aClass = Livro.class)
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;

    private String sumario;
    @NotNull @DecimalMin("20.0")
    private BigDecimal preco;
    @NotNull @Min(100)
    private Integer paginas;
    @NotBlank @ValidarCampoDuplicado(atributo = "isbn", aClass = Livro.class)
    private String isbn;
    @Future
    private LocalDate dataPublicacao;
    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = Grupo.Categoria.class)
    private Categoria categoria;
    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = Grupo.Autor.class)
    private Autor autor;

    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas,
                        String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public Livro toLivro(){
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.paginas, this.isbn,
                this.dataPublicacao, this.categoria, this.autor);
    }
}
