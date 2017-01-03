package com.av.ui.controllers;

import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public class AbstractController implements Controller {

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
