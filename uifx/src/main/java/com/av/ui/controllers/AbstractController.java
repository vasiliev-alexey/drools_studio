package com.av.ui.controllers;

import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public abstract class AbstractController implements Controller {

    protected Node view;


    protected static void setReadOnly(Pane mainPane) {
        mainPane.getChildren().forEach( node ->  {

            if(node instanceof TableView) {
                ((TableView) node).setEditable(false);
            }
            else if (node instanceof TextField)
                ((TextField) node).setEditable(false);
            else  if(node instanceof Pane) {
                setReadOnly((Pane) node);
            }
            else if(node instanceof ComboBox) {
                //node.setDisable(true);
              //  ( (ComboBox)node).setEditable(false);
                node.setStyle("-fx-opacity: 1");
                ( (ComboBox)node).setVisibleRowCount(0);
            }
            else  if (node instanceof CheckBox) {
                node.setDisable(true);
                node.setStyle("-fx-opacity: 1");
            }

        });
    }

    @Override
    public Node getView() {
        return view;
    }

    @Override
    public void setView(Node view) {
        this.view = view;

    }

     public     void refresh() {

     } ;

}
