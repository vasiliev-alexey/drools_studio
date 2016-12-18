package com.av.ui.controlers;

import com.av.domain.Model;
import com.av.ui.treeitems.ModelTreeItem;
import javafx.event.EventHandler;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

/**
 * Created by vasiliev-alexey on 17.12.16.
 */
public class TreeModelEvent implements EventHandler<MouseEvent> {


    @Override
    public void handle(MouseEvent event) {

       TreeView a =  (TreeView) event.getSource();

        ModelTreeItem s = (ModelTreeItem)a.getSelectionModel().getSelectedItem();

        System.out.println("mouse click + " + s.getValue());
    }
}
