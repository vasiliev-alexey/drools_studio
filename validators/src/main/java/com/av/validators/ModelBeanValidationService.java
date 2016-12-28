package com.av.validators;

import com.av.domain.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by vasiliev-alexey on 27.12.16.
 */
@Service
public class ModelBeanValidationService {

    @Autowired
    @Qualifier("validator")
    private Validator validator;


    public Set<ConstraintViolation<Model>> validateModel(Model model) {
        return validator.validate(model);
    }

}
