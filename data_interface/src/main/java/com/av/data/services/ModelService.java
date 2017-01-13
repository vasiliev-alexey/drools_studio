package com.av.data.services;

import com.av.domain.Model;
import javafx.collections.ObservableList;
import org.springframework.cache.annotation.CacheEvict;


/**
 * Created by alexey on 25.11.16.
 */
public interface ModelService {

    @CacheEvict
    Model Save(Model model);


    ObservableList<Model> getAll();


    Model refresh(Model model);

}
