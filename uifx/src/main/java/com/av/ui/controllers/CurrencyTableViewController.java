package com.av.ui.controllers;

import com.av.data.services.CurrencyService;
import com.av.domain.accounting.Currency;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by vasiliev-alexey on 22.01.17.
 */
public class CurrencyTableViewController extends AbstractController implements Initializable {

    @FXML
    private TableView<Currency> tableCurrency;

    private ObservableList<Currency> modelData = FXCollections.observableArrayList();

    @Autowired
    private CurrencyService currencyService;

    @FXML
    private TableColumn<Currency, String> codeColumn;
    @FXML
    private TableColumn<Currency, String> nameColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        modelData = currencyService.getAll();
        tableCurrency.setItems( modelData);



    }
}
