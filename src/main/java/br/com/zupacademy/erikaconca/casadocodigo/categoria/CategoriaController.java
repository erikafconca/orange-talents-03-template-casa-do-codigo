package br.com.zupacademy.erikaconca.casadocodigo.categoria;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public void salvarCategoria(@RequestBody Categoria categoria){
        repository.save(categoria);

    }

}
