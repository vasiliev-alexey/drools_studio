package com.av.data.services;

import com.av.domain.accounting.ChartOfAccountStructure;
import javafx.collections.ObservableList;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by vasiliev-alexey on 25.01.17.
 */
public interface ChartOfAccountStructureService extends AbstractEntityService<ChartOfAccountStructure> {

}
