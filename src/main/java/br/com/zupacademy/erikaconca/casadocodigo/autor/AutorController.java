package br.com.zupacademy.erikaconca.casadocodigo.autor;


import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
   public void cadastrarAutor(@RequestBody @Valid AutorRequest autorRequest){

        Autor autor = autorRequest.toAutor();
        repository.save(autor);

   }
}
