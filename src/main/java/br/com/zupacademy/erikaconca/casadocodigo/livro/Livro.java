package br.com.zupacademy.erikaconca.casadocodigo.livro;

import br.com.zupacademy.erikaconca.casadocodigo.autor.Autor;
import br.com.zupacademy.erikaconca.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    @Column(nullable = false, length = 500)
    private String resumo;
    @Column(columnDefinition = "text null")
    private String sumario;
    @Column(nullable = false)
    private BigDecimal preco;
    @Column(nullable = false)
    private Integer paginas;
    @Column(nullable = false, unique = true)
    private String isbn;
    private LocalDate dataPublicacao;
    @NotNull
    @ManyToOne
    private Categoria categoria;
    @NotNull
    @ManyToOne
    private Autor autor;

    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario,
                 BigDecimal preco, Integer paginas, String isbn, LocalDate dataPublicacao, Categoria categoria,
                 Autor autor) {
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

    public Long getId() {
        return id;
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


    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
