package br.com.zupacademy.erikaconca.casadocodigo.validadore;

import br.com.zupacademy.erikaconca.casadocodigo.cliente.ClienteRequest;
import br.com.zupacademy.erikaconca.casadocodigo.localizacao.EstadoRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidarEstadoValidator implements ConstraintValidator<ValidarEstado, ClienteRequest> {

    private EstadoRepository repository;

    public ValidarEstadoValidator(EstadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(ClienteRequest clienteRequest, ConstraintValidatorContext context) {

//        Long estadoId = clienteRequest.getEstado().getId();
        Long paisId = clienteRequest.getPais().getId();

        if(clienteRequest.getEstado() == null){

            if(repository.existsByPaisId(paisId)){
                System.out.println("dentro pais com estado : " + repository.existsByPaisId(paisId));
                return false;
            }

        }else{
            Long estadoId = clienteRequest.getEstado().getId();
            if(!repository.existsByIdAndPais_Id(estadoId, paisId)){
                System.out.println("dentro pais com estado e pais : " + !repository.existsByIdAndPais_Id(estadoId, paisId));
                return false;
            }
        }
        System.out.println("dentro pais sem estado : " + repository.existsByPaisId(paisId));
        return true;

    }
}
