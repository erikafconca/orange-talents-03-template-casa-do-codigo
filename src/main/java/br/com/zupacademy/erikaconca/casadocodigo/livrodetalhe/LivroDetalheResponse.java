package br.com.zupacademy.erikaconca.casadocodigo.livrodetalhe;

import java.math.BigDecimal;

public class LivroDetalheResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private String isbn;
    private AutorResponse autorResponse;


    public LivroDetalheResponse(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas,
                                String isbn, AutorResponse autorResponse) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.autorResponse = autorResponse;
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

    public AutorResponse getAutorResponse() {
        return autorResponse;
    }
}
