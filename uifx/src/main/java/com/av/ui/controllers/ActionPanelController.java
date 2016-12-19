package com.av.ui.controllers;

import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by vasiliev-alexey on 19.12.16.
 */
@org.springframework.stereotype.Controller
public class ActionPanelController implements Initializable , Serializable , Controller{

   private Node view;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public Node getView() {
        return view;
    }

    public void setView(Node view) {
        this.view = view;
    }
}
