package com.av.repositories;

import com.av.domain.Model;
import javafx.collections.ObservableList;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


/**
 * Created by alexey on 25.11.16.
 */
public interface ModelService {

    @CacheEvict (cacheNames = "model" )
    Model Save(Model model);


   @Cacheable(cacheNames = "model")
    ObservableList<Model> getAll();


    Model refresh(Model model);

}
