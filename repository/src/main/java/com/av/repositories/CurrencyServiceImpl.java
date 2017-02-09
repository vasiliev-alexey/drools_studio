package com.av.repositories;

import com.av.data.services.CurrencyService;
import com.av.domain.accounting.Currency;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * Created by vasiliev-alexey on 21.01.17.
 */
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public Currency save(Currency currency) {
        if (currency.getId() == 0) {
            emf.persist(currency);
        } else {
            emf.merge(currency);
        }
        return currency;
    }

    @Override
    @Transactional(readOnly = true)
    public ObservableList<Currency> getAll() {
        CriteriaBuilder cb = emf.getCriteriaBuilder();
        CriteriaQuery<Currency> cq = cb.createQuery(Currency.class);
        Root<Currency> rootEntry = cq.from(Currency.class);
        CriteriaQuery<Currency> all = cq.select(rootEntry);
        TypedQuery<Currency> allQuery = emf.createQuery(all);
        return FXCollections.observableArrayList(allQuery.getResultList());
    }

    @Override
    public void remove(Currency currency) {
        emf.remove(currency);
    }
}
