package br.com.zupacademy.erikaconca.casadocodigo.validadore;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidarEstadoValidator.class})

public @interface ValidarEstado {

    String message() default "Estado não permitido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
