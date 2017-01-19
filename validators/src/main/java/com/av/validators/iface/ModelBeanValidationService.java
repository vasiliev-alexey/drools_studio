package com.av.validators.iface;

import com.av.domain.settings.Error;
import com.av.domain.settings.Model;
import javafx.collections.ObservableList;

/**
 * Created by vasiliev-alexey on 02.01.17.
 */
public interface ModelBeanValidationService {
      ObservableList<Error> validateModel(Model model);
}
