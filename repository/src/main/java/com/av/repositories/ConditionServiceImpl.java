package com.av.repositories;

import com.av.data.services.ConditionService;
import com.av.domain.settings.AbstractCondition;
import com.av.domain.settings.Condition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Vasiliev.Alexey on 27.11.16.
 */
//@Service(value = "conditionService")
@Repository
@Transactional
public class ConditionServiceImpl implements ConditionService {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public Condition save(Condition condition) {
        if (condition.getId() == null || condition.getId() == 0) {
            emf.persist(condition);
        } else {
            emf.merge(condition);
        }
        return condition;
    }
}