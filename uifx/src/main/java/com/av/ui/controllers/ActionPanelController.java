package com.av.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.input.MouseEvent;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by vasiliev-alexey on 19.12.16.
 */
@org.springframework.stereotype.Controller
public class ActionPanelController extends  AbstractController implements Initializable , Serializable   {


    private TableSelectionModel tableModel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }


    public void addItem(MouseEvent mouseEvent) {

        throw new RuntimeException("Не реализовано");

    }

    public void editItem(MouseEvent mouseEvent) {

        System.out.println(tableModel.getSelectedItem());



    }


    public void setTableModel(TableSelectionModel tableModel) {
        this.tableModel = tableModel;
    }

}
