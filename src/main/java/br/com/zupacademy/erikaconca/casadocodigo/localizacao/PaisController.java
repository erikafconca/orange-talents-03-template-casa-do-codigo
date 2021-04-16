package br.com.zupacademy.erikaconca.casadocodigo.localizacao;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private PaisRepository repository;

    public PaisController(PaisRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void salvarPais(@RequestBody @Valid PaisRequest paisRequest){

        repository.save(paisRequest.toPais());

    }

}
