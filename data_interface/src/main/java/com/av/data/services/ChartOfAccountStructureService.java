package com.av.data.services;

import com.av.domain.accounting.ChartOfAccountStructure;
import javafx.collections.ObservableList;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by vasiliev-alexey on 25.01.17.
 */
public interface ChartOfAccountStructureService {

    @CacheEvict(cacheNames = "chartOfAccountStructure"  )
    ChartOfAccountStructure Save(ChartOfAccountStructure chartOfAccountStructure);


    @Cacheable(cacheNames = "chartOfAccountStructure")
    ObservableList<ChartOfAccountStructure> getAll();


    ChartOfAccountStructure refresh(ChartOfAccountStructure data);

    @CacheEvict (cacheNames = "chartOfAccountStructure"  , allEntries = true)
    void remove(ChartOfAccountStructure chartOfAccountStructure);

}
