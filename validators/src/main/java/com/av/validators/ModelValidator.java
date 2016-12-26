package com.av.validators;


import com.av.domain.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by vasiliev-alexey on 26.12.16.
 */
public class ModelValidator implements Validator {

    public static final  String CODEEMPTY = "model.code.not_empty";
    public static final  String PACKAGEEMPTY = "model.package.not_empty";



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
        ValidationUtils.rejectIfEmpty(errors, "code", CODEEMPTY,
                "Код модели не должен быть пустым");

        ValidationUtils.rejectIfEmpty(errors, "packageName", CODEEMPTY,
                "Пакет для  модели не должен быть пустым");

    }
}
