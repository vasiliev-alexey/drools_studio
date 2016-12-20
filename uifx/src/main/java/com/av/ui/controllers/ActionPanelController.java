package com.av.ui.controllers;

import com.av.domain.Model;
import com.av.ui.managers.AbstractDataManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.input.MouseEvent;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 19.12.16.
 */
@org.springframework.stereotype.Controller
public class ActionPanelController extends  AbstractController implements Initializable , Serializable   {


    private static Logger logger = Logger.getLogger(ActionPanelController.class.getName());


    private TableSelectionModel tableSelectionModel;

    public void setTableSelectionModel(TableSelectionModel tableSelectionModel) {
        this.tableSelectionModel = tableSelectionModel;
    }

    public void setDataManager(AbstractDataManager dataManager) {
        this.dataManager = dataManager;
    }

    private AbstractDataManager dataManager;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    @FXML
    public void addItem(MouseEvent mouseEvent) {


        dataManager.addItem(new Model());


    }
    @FXML
    public void editItem(MouseEvent mouseEvent) {

        Model model = (Model) tableSelectionModel.getSelectedItem();

        if(!tableSelectionModel.isEmpty()) {
            model.setModelName("1111111111111111");
        } else  {
            logger.log( Level.WARNING , "model not selected");
        }



//        tableSelectionModel.notifyAll();



    }




}
