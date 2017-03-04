package com.av.data.services;

import com.av.domain.accounting.AccountCalendar;
import javafx.collections.ObservableList;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vasiliev-alexey on 19.01.17.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface AccountCalendarService extends AbstractEntityService<AccountCalendar> {

}
