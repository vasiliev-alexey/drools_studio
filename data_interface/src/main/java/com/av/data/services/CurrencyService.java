package com.av.data.services;

import com.av.domain.accounting.Currency;
import javafx.collections.ObservableList;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by vasiliev-alexey on 21.01.17.
 */
public interface CurrencyService {

    @CacheEvict(cacheNames = "accountSettings"  , allEntries = true)
    Currency Save(Currency currency);


    @Cacheable(cacheNames = "accountSettings")
    ObservableList<Currency> getAll();



    @CacheEvict (cacheNames = "accountSettings"  , allEntries = true)
    void remove(Currency currency);
}
