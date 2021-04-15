package br.com.zupacademy.erikaconca.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

    private Long id;
    private String nome;

    public LivroResponse() {
    }

    public LivroResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<LivroResponse> toLivroResponse(List<Livro> livros){

        List<LivroResponse> livroResponse = livros.stream()
                .map(e->new LivroResponse(e.getId(),e.getTitulo()))
                .collect(Collectors.toList());
        return livroResponse;
    }
}
