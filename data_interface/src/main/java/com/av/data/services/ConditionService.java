package com.av.data.services;

import com.av.domain.settings.AbstractCondition;
import com.av.domain.settings.Condition;

/**
 * Created by Vasiliev.Alexey on 27.11.16.
 */
public interface ConditionService {

    Condition save(Condition condition);
}
