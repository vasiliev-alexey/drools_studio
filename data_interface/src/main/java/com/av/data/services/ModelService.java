package com.av.data.services;

import com.av.domain.settings.Model;
import javafx.collections.ObservableList;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


/**
 * Created by alexey on 25.11.16.
 */
public interface ModelService {

    @CacheEvict (cacheNames = "model"  )
    Model save(Model model);


   @Cacheable(cacheNames = "model")
    ObservableList<Model> getAll();


    Model refresh(Model model);
    @CacheEvict (cacheNames = "model"  , allEntries = true)
    void remove(Model model);
}
