package com.av.repositories;

import com.av.domain.AbstractCondition;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Vasiliev.Alexey on 27.11.16.
 */
public class ConditionServiceImpl implements ConditionService {
    @PersistenceContext
    private EntityManager emf;

    @Override
    public AbstractCondition Save(AbstractCondition condition) {
        if (condition.getId() == null) {
            emf.persist(condition);
        } else {
            emf.merge(condition);
        }
        return condition;
    }
}