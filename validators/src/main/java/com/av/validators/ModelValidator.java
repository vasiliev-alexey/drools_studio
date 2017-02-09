package com.av.validators;


import com.av.domain.settings.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by vasiliev-alexey on 26.12.16.
 */
public class ModelValidator implements Validator {

    public static final  String CODEEMPTY = "model.code.not_empty";
    public static final  String PACKAGEEMPTY = "model.package.not_empty";

    @Autowired
    private javax.validation.Validator validator;

    @Override
    public boolean supports(Class<?> aClass) {
        return Model.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {





         Set<ConstraintViolation<Object>> constraintViolations = validator.validate(o);
	        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
	            String propertyPath = constraintViolation.getPropertyPath().toString();
	            String message = constraintViolation.getMessage();
	            errors.rejectValue(propertyPath, "", message);
	        }


    }
}
