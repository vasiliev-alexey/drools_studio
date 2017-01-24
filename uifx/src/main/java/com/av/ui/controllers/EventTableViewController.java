package com.av.ui.controllers;

import com.av.data.services.EventService;
import com.av.domain.accounting.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by vasiliev-alexey on 21.12.16.
 */
//@org.springframework.stereotype.Controller
public class EventTableViewController extends AbstractController implements Initializable {


    private ObservableList<Event> events = FXCollections.observableArrayList();

    @FXML
    private TableView<Event> tableModels;

    @FXML
    private TableColumn<Event, String> codeColumn;
    @FXML
    private TableColumn<Event, String> nameColumn;
    @FXML
    private TableColumn<Event, String> modelName;
    @FXML
    private TableColumn<Event, String> modelCode;
    @FXML
    private TableColumn<Event, Boolean> enabled_flag;




    @Autowired
    private EventService eventService;


    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        codeColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("code"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("name"));
        enabled_flag.setCellValueFactory(new PropertyValueFactory<Event, Boolean>("enabled"));
        enabled_flag.setCellFactory(CheckBoxTableCell.forTableColumn(enabled_flag));
        modelName.setCellValueFactory(data -> {
            if (data.getValue().modelProperty().getValue() == null) return null;
            return data.getValue().modelProperty().getValue().modelNameProperty();
        });
        modelCode.setCellValueFactory(data -> {
            if (data.getValue().modelProperty().getValue() == null) return null;
            return data.getValue().modelProperty().getValue().codeProperty();
        });

        events = FXCollections.observableArrayList(eventService.findAll());
        tableModels.setItems(events);
        tableModels.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);




    }


}
