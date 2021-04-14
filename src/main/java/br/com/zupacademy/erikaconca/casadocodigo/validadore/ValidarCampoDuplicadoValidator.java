package br.com.zupacademy.erikaconca.casadocodigo.validadore;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidarCampoDuplicadoValidator implements ConstraintValidator<ValidarCampoDuplicado, Object> {

    @PersistenceContext
    private EntityManager manager;

    private String atributo;
    private Class<?> aClass;

    @Override
    public void initialize(ValidarCampoDuplicado constraintAnnotation) {
        this.atributo = constraintAnnotation.atributo();
        this.aClass = constraintAnnotation.aClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        Query query = manager.createQuery("SELECT 1 FROM " +
                aClass.getName() + "WHERE" + atributo + "=:valor");
        query.setParameter("valor", value);

        List<String> resultados = query.getResultList();

        return resultados.size() > 0? false: true;
    }
}
