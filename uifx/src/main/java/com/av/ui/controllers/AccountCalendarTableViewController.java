package com.av.ui.controllers;

import com.av.data.services.AccountCalendarService;
import com.av.domain.accounting.AccountCalendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by vasiliev-alexey on 22.01.17.
 */
public class AccountCalendarTableViewController extends AbstractController implements Initializable {

    private ObservableList<AccountCalendar> accountCalendarData = FXCollections.observableArrayList();

    @Autowired
    private AccountCalendarService accountCalendarService;

    @FXML
    private TableView<AccountCalendar> accountCalendarTableView;


    @FXML
    private TableColumn<AccountCalendar, String> codeColumn;
    @FXML
    private TableColumn<AccountCalendar, String> nameColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


        accountCalendarData = accountCalendarService.getAll();
        accountCalendarTableView.setItems(accountCalendarData);
        accountCalendarTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

}
