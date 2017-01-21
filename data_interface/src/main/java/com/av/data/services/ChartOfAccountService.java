package com.av.data.services;

import com.av.domain.accounting.ChartOfAccount;
import javafx.collections.ObservableList;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by vasiliev-alexey on 21.01.17.
 */
public interface ChartOfAccountService {


    ObservableList<ChartOfAccount> save(ObservableList<ChartOfAccount> chartOfAccounts) ;
    }
