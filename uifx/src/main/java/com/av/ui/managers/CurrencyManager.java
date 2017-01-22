package com.av.ui.managers;

import com.av.domain.accounting.Currency;
import com.av.ui.controllers.CurrencyTableViewController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 22.01.17.
 */
@Service
@Lazy
public class CurrencyManager extends AbstractDataManager<Currency> {

    private static Logger currencyLogger = Logger.getLogger(CurrencyManager.class.getName());


    @Autowired
    private CurrencyTableViewController currencyTableViewController;

    @Override
    public Currency addItem() {
        return null;
    }

    @Override
    public String getLabel() {
        return "Валюты";
    }

    @Override
    public String getViewName() {
        return "/fxml/CurrencyTableView.fxml";
    }
}
