package com.av.ui.controllers;

import com.av.domain.Event;
import com.av.ui.managers.AbstractDataManager;
import com.av.ui.managers.ModelManager;
import com.av.ui.utils.SpringFXMLLoader;
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


        TreeView a = (TreeView) event.getSource();

        a.disableProperty().setValue(true);

        TreeItem selectedItem =  (TreeItem) a.getSelectionModel().getSelectedItem();

        try {
/**/
            if (selectedItem.getValue() instanceof ModelManager) {
                topPanel.getChildren().removeAll();

                Controller controller =   SpringFXMLLoader.load("/fxml/ModelTableView.fxml");
                TableView tableView = (TableView) controller.getView();
                tableView.setPrefWidth(-1.0);
                AnchorPane.setLeftAnchor(tableView, 0.0);
                AnchorPane.setRightAnchor(tableView, 0.0);
                AnchorPane.setBottomAnchor(tableView, 0.0);
                AnchorPane.setTopAnchor(tableView, 0.0);
                topPanel.getChildren().addAll(tableView);
                ActionPanelController actionPanelController = (ActionPanelController) SpringFXMLLoader.load("/fxml/ActionPane.fxml");
                actionPanelController.setDataManager((AbstractDataManager) selectedItem.getValue());

                actionPanelController.setTableSelectionModel(((TableView) controller.getView()).getSelectionModel());

                HBox actionBox = (HBox) actionPanelController.getView();
                actionPane.getChildren().addAll(actionBox);
            } else if (selectedItem instanceof TreeItem && ((TreeItem) selectedItem).getValue() instanceof Event) {
                System.out.println("Логика для события");
            }
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
