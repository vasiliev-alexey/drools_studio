package com.av.ui.controllers;

import com.av.domain.Model;
import com.av.repositories.ModelService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by vasiliev-alexey on 19.12.16.
 */

public class ModelTableViewController extends AbstractController implements Initializable {



    private ObservableList<Model> modelData = FXCollections.observableArrayList();

    @FXML
    private TableView<Model> tableModels;

    @FXML
    private TableColumn<Model , String>  codeColumn;
    @FXML
    private TableColumn<Model , String>  nameColumn;

    @Autowired
    private ModelService modelService;


    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        codeColumn.setCellValueFactory(new PropertyValueFactory<Model, String>("code"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Model, String>("name"));

        modelData = modelService.getAll();
        tableModels.setItems(modelData);
        tableModels.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }



}
