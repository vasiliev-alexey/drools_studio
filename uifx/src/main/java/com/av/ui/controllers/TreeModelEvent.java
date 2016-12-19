package com.av.ui.controllers;

import com.av.ui.treeitems.ModelTreeItem;
import com.av.ui.utils.SpringFXMLLoader;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Created by vasiliev-alexey on 17.12.16.
 */
public class TreeModelEvent implements EventHandler<MouseEvent> {

    private Pane topPanel;
    private Pane actionPane;

    public TreeModelEvent(Pane actionPane, Pane topPanel) {
        super();
        this.topPanel = topPanel;
        this.actionPane = actionPane;
    }

    @Override
    public void handle(MouseEvent event) {
        TreeView a = (TreeView) event.getSource();
        ModelTreeItem s = (ModelTreeItem) a.getSelectionModel().getSelectedItem();

        topPanel.getChildren().removeAll();

        ModelTableViewController controller = (ModelTableViewController) SpringFXMLLoader.load("/fxml/ModelTableView.fxml");
        TableView root = (TableView) controller.getView();
        root.setPrefWidth(-1.0);
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);
        AnchorPane.setTopAnchor(root, 0.0);
        topPanel.getChildren().addAll(root);
        ActionPanelController actionPanelController = (ActionPanelController) SpringFXMLLoader.load("/fxml/ActionPane.fxml");

        HBox actionBox = (HBox) actionPanelController.getView();
        actionPane.getChildren().addAll(actionBox);

    }
}
