package com.av.ui.controllers;

import com.av.ui.managers.AbstractDataManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.input.MouseEvent;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 19.12.16.
 */

public class ActionPanelController extends AbstractController implements Initializable {

    private static Logger logger = Logger.getLogger(ActionPanelController.class.getName());
    private TableSelectionModel tableSelectionModel;
    private AbstractDataManager dataManager;

    public void setTableSelectionModel(TableSelectionModel tableSelectionModel) {
        this.tableSelectionModel = tableSelectionModel;
    }

    public void setDataManager(AbstractDataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void addItem(MouseEvent mouseEvent) {
        dataManager.addItem();
    }

    @FXML

    public void editItem(MouseEvent mouseEvent) {

        Object model = tableSelectionModel.getSelectedItem();
        logger.info("Edit data object" + model);
        if (!tableSelectionModel.isEmpty()) {

            dataManager.editItem(model);
        } else {
            logger.info("object not selected");
        }

    }


}
