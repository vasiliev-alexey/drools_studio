package com.av.validators;

import com.av.domain.Error;
import com.av.domain.Model;
import com.av.validators.iface.ModelBeanValidationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by vasiliev-alexey on 27.12.16.
 */
@Service
public class ModelBeanValidationServiceImpl implements ModelBeanValidationService
{

    @Autowired
    @Qualifier("validator")
    private Validator validator;


    public ObservableList<Error> validateModel(Model model) {

        final ObservableList<Error> errors= FXCollections.observableArrayList();

        Set<ConstraintViolation<Model>> tmpErr =  validator.validate(model);

        if (tmpErr == null || tmpErr.size() == 0) return errors;
         tmpErr.forEach( e -> {
             errors.add(new Error(e.getInvalidValue().toString() , e.getMessage()));
         });

        return errors;
    }

}
