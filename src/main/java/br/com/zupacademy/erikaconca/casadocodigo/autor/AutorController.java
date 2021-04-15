package br.com.zupacademy.erikaconca.casadocodigo.autor;


import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void cadastrarAutor(@RequestBody @Valid AutorRequest autorRequest) {

        repository.save(autorRequest.toAutor());

    }

    @GetMapping
    public List<Autor> listar() {
        return repository.findAll();
    }
}
