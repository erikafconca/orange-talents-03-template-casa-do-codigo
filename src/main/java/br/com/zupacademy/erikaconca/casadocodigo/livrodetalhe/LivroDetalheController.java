package br.com.zupacademy.erikaconca.casadocodigo.livrodetalhe;

import br.com.zupacademy.erikaconca.casadocodigo.livro.Livro;
import br.com.zupacademy.erikaconca.casadocodigo.livro.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/livrosdetalhes")
public class LivroDetalheController {

    private LivroRepository repository;

    public LivroDetalheController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{livroId}")
    public ResponseEntity<?> listarDetalhes(@PathVariable Long livroId) {

        Optional<Livro> livro = repository.findById(livroId);

        if (livro.isPresent()) {

            Livro livroEncontrado = livro.get();

            LivroDetalheResponse livroDetalheResponse =
                    new LivroDetalheResponse(livroEncontrado.getTitulo(),
                            livroEncontrado.getResumo(),
                            livroEncontrado.getSumario(),
                            livroEncontrado.getPreco(),
                            livroEncontrado.getPaginas(),
                            livroEncontrado.getIsbn(),
                            new AutorResponse(livroEncontrado.getAutor().getNome(),
                                    livroEncontrado.getAutor().getDescricao()));

            return ResponseEntity.ok(livroDetalheResponse);

        }

        return ResponseEntity.notFound().build();


    }
}