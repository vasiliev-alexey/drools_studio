package com.av.data.services;

import com.av.domain.accounting.Currency;
import javafx.collections.ObservableList;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by vasiliev-alexey on 21.01.17.
 */
public interface CurrencyService extends AbstractEntityService<Currency> {


}
