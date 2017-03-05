package com.av.repositories;

import com.av.data.services.AccountCalendarService;
import com.av.domain.accounting.AccountCalendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by vasiliev-alexey on 19.01.17.
 */
public class AccountCalendarServiceImpl extends AbstracrService<AccountCalendar> implements AccountCalendarService {

    @PersistenceContext
    private EntityManager emf;


    @Override
    @CacheEvict(cacheNames = "accountSettings"  , allEntries = true)
    @Transactional
    public AccountCalendar save(AccountCalendar data) {
        return  super.save(data);
    }


    @Override
    @Cacheable(cacheNames = "accountSettings")
    @Transactional(readOnly = true)
    public ObservableList<AccountCalendar> getAll() {
       return super.getAll();
    }

    @Override
    @CacheEvict (cacheNames = "accountSettings"  , allEntries = true)
    @Transactional
    public void remove(AccountCalendar data) {
        super.remove(data);
    }
}
