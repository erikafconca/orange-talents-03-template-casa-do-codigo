package br.com.zupacademy.erikaconca.casadocodigo.livro;

import br.com.zupacademy.erikaconca.casadocodigo.autor.Autor;
import br.com.zupacademy.erikaconca.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.erikaconca.casadocodigo.categoria.Categoria;
import br.com.zupacademy.erikaconca.casadocodigo.categoria.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroRepository repository;
    private CategoriaRepository categoriaRepository;
    private AutorRepository autorRepository;

    public LivroController(LivroRepository repository, CategoriaRepository categoriaRepository,
                           AutorRepository autorRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<?> salvarLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Optional<Categoria> categoria = categoriaRepository.findById(livroRequest.getCategoria().getId());
        Optional<Autor> autor = autorRepository.findById(livroRequest.getAutor().getId());

        if (categoria.isPresent() && autor.isPresent()) {
            Livro livro = livroRequest.toLivro();
            livro.setCategoria(categoria.get());
            livro.setAutor(autor.get());
            repository.save(livro);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public List<LivroResponse> listarTodos() {
        LivroResponse livroResponse = new LivroResponse();
        return livroResponse.toLivroResponse(repository.findAll());

    }
}
