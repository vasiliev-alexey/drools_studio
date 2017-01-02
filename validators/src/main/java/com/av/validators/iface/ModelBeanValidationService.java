package com.av.validators.iface;

import com.av.domain.Error;
import com.av.domain.Model;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by vasiliev-alexey on 02.01.17.
 */
public interface ModelBeanValidationService {
      ObservableList<Error> validateModel(Model model);
}
