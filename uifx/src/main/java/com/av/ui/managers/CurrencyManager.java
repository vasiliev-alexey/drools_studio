package com.av.ui.managers;

import com.av.domain.accounting.Currency;
import com.av.ui.controllers.CurrencyTableViewController;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    private static Logger logger = Logger.getLogger(CurrencyManager.class.getName());


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


    @Override
    public Node getIcon() {
        return new ImageView(new Image(
                getClass().getResourceAsStream("/icons/currency_16x16.png")));
    }

}
