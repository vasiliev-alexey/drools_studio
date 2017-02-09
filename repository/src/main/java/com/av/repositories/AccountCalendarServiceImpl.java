package com.av.repositories;

import com.av.data.services.AccountCalendarService;
import com.av.domain.accounting.AccountCalendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by vasiliev-alexey on 19.01.17.
 */
public class AccountCalendarServiceImpl implements AccountCalendarService {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public AccountCalendar save(AccountCalendar data) {

        if (data.getId() == 0) {
            emf.persist(data);
        } else {
            emf.merge(data);
        }
        return data;

    }

    @Override
    public ObservableList<AccountCalendar> getAll() {
        CriteriaBuilder cb = emf.getCriteriaBuilder();
        CriteriaQuery<AccountCalendar> cq = cb.createQuery(AccountCalendar.class);
        Root<AccountCalendar> rootEntry = cq.from(AccountCalendar.class);
        CriteriaQuery<AccountCalendar> all = cq.select(rootEntry);
        TypedQuery<AccountCalendar> allQuery = emf.createQuery(all);
        return FXCollections.observableArrayList(allQuery.getResultList());
    }

    @Override
    public void remove(AccountCalendar data) {
        emf.remove(data);

    }
}
