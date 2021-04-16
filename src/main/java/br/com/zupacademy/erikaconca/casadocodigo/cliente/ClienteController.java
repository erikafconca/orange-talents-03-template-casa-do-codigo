package br.com.zupacademy.erikaconca.casadocodigo.cliente;

import com.example.demo.localizacao.EstadoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository repository;
    private EstadoRepository estadoRepository;

    public ClienteController(ClienteRepository repository, EstadoRepository estadoRepository) {
        this.repository = repository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public Long salvarCliente(@RequestBody @Valid ClienteRequest clienteRequest){

        Cliente cliente = repository.save(clienteRequest.toCliente());
        return cliente.getId();


    }

}
