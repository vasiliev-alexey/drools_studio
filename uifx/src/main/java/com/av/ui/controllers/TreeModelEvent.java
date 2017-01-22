package com.av.ui.controllers;

import com.av.ui.managers.AbstractDataManager;
import com.av.ui.utils.SpringFXMLLoader;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Component;

/**
 * Created by vasiliev-alexey on 17.12.16.
 */
@Component
public class TreeModelEvent implements EventHandler<MouseEvent> {

    private Pane topPanel;
    private Pane actionPane;
    private Pane bottomPane;


    @Override
    public void handle(MouseEvent event) {

        actionPane.getChildren().clear();
        topPanel.getChildren().clear();
        bottomPane.getChildren().clear();


        ActionPanelController actionPanelController = null;
        Controller controller;
        TableView tableView;


        TreeView a = (TreeView) event.getSource();



        TreeItem selectedItem = (TreeItem) a.getSelectionModel().getSelectedItem();
        if(!selectedItem.isLeaf() || !(selectedItem.getValue() instanceof AbstractDataManager)) {
            return;
        }
        a.disableProperty().setValue(true);

        actionPanelController = (ActionPanelController) SpringFXMLLoader.load("/fxml/ActionPane.fxml");

        try {

            controller = SpringFXMLLoader.load(((AbstractDataManager) selectedItem.getValue()).getViewName());

            tableView = (TableView) controller.getView();
            tableView.setPrefWidth(-1.0);
            AnchorPane.setLeftAnchor(tableView, 0.0);
            AnchorPane.setRightAnchor(tableView, 0.0);
            AnchorPane.setBottomAnchor(tableView, -1d);

            tableView.setFixedCellSize(25);
            tableView.prefHeightProperty().bind(Bindings.size(tableView.getItems()).multiply(tableView.getFixedCellSize()).add(30));

            AnchorPane.setTopAnchor(tableView, 0.0);

            topPanel.getChildren().addAll(tableView);
            actionPanelController.setDataManager((AbstractDataManager) selectedItem.getValue());

            actionPanelController.setTableSelectionModel(((TableView) controller.getView()).getSelectionModel());
            HBox actionBox = (HBox) actionPanelController.getView();
            actionPane.getChildren().addAll(actionBox);

        } finally {
            a.disableProperty().setValue(false);
            event.consume();

        }
    }

    public void setTopPanel(Pane topPanel) {
        this.topPanel = topPanel;
    }

    public void setActionPane(Pane actionPane) {
        this.actionPane = actionPane;
    }

    public void setBottomPane(Pane bottomPane) {
        this.bottomPane = bottomPane;
    }

}
