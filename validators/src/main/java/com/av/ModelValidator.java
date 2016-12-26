package com.av;


import com.av.domain.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by vasiliev-alexey on 26.12.16.
 */
public class ModelValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Model.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Model m = (Model)o;


        if(m.getModelName() == null || m.getModelName().isEmpty()){
            String msg2 = "Имя модели не может быть пустым";
            errors.rejectValue("name","model.name.empty",msg2);
        }

    }
}
