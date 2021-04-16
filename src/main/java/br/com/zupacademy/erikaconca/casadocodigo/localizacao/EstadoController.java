package br.com.zupacademy.erikaconca.casadocodigo.localizacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoRepository estadoRepository;
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository,
                            PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> metodo(@RequestBody @Valid EstadoRequest estadoRequest){

        Optional<Pais> pais = paisRepository.findById(estadoRequest.getPais().getId());

        if(pais.isPresent()){

            if(!estadoRepository.existsByNomeAndPais_Id(estadoRequest.getNome(),
                    estadoRequest.getPais().getId())){

                estadoRepository.save(estadoRequest.toEstado());
                return ResponseEntity.ok().build();

            }

        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"País nao encontrado");


    }

}


