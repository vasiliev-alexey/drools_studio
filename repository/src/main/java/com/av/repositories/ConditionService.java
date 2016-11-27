package com.av.repositories;

import com.av.domain.AbstractCondition;

/**
 * Created by Vasiliev.Alexey on 27.11.16.
 */
public interface ConditionService {

    AbstractCondition Save(AbstractCondition condition);
}
