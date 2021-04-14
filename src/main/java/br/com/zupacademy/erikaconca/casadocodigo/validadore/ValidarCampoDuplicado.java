package br.com.zupacademy.erikaconca.casadocodigo.validadore;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidarCampoDuplicadoValidator.class})
public @interface ValidarCampoDuplicado {

    String message() default "Campos duplicados";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String atributo();
    Class<?> aClass();
}
