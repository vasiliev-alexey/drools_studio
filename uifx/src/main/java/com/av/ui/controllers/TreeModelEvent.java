package com.av.ui.controllers;

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
    private Pane bottomPane;

    public TreeModelEvent(Pane actionPane, Pane topPanel, AnchorPane bottomPane) {
        super();
        this.topPanel = topPanel;
        this.actionPane = actionPane;
        this.bottomPane = bottomPane;
    }

    @Override
    public void handle(MouseEvent event) {


        TreeView a = (TreeView) event.getSource();

        a.disableProperty().setValue(true);
        try {
/**/

            topPanel.getChildren().removeAll();

            ModelTableViewController controller = (ModelTableViewController) SpringFXMLLoader.load("/fxml/ModelTableView.fxml");
            TableView tableView = (TableView) controller.getView();
            tableView.setPrefWidth(-1.0);
            AnchorPane.setLeftAnchor(tableView, 0.0);
            AnchorPane.setRightAnchor(tableView, 0.0);
            AnchorPane.setBottomAnchor(tableView, 0.0);
            AnchorPane.setTopAnchor(tableView, 0.0);
            topPanel.getChildren().addAll(tableView);
            ActionPanelController actionPanelController = (ActionPanelController) SpringFXMLLoader.load("/fxml/ActionPane.fxml");

            actionPanelController.setTableModel(((TableView) controller.getView()).getSelectionModel());

            HBox actionBox = (HBox) actionPanelController.getView();
            actionPane.getChildren().addAll(actionBox);
        } finally {
            a.disableProperty().setValue(false);
            event.consume();

        }





    }
}
