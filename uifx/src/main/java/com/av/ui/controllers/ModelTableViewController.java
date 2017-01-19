package com.av.ui.controllers;

import com.av.data.services.ModelService;
import com.av.domain.settings.Model;

import com.av.ui.utils.SpringFXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by vasiliev-alexey on 19.12.16.
 */

public class ModelTableViewController extends AbstractController implements Initializable {


    private static double ANCHOR_CONSTANT = 0.0;
    private ObservableList<Model> modelData = FXCollections.observableArrayList();

    @FXML
    private TableView<Model> tableModels;


    @FXML
    private TableColumn<Model, String> codeColumn;
    @FXML
    private TableColumn<Model, String> nameColumn;

    @Autowired
    private ModelService modelService;


    @Autowired
    private AnchorPane bottomPane;


    private ModelShortViewController shortViewController;


    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("modelName"));


        modelData = modelService.getAll();
        tableModels.setItems(modelData);
        tableModels.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        tableModels.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            mouseEnterd(null);
        });
    }


    /**
     *  метод слушает событие прохождения над гридом  с моделями для прорисовки сокращенного вида
     * @param mouseEvent - событие по прохождению курсора мыши над таблицей с моделями
     */
    private void mouseEnterd(MouseEvent mouseEvent) {
        bottomPane.getChildren().clear();
        shortViewController = (ModelShortViewController) SpringFXMLLoader.load("/fxml/ModelShortView.fxml");
        Node view = shortViewController.getView();


        AnchorPane.setLeftAnchor(view, ANCHOR_CONSTANT);
        AnchorPane.setRightAnchor(view, ANCHOR_CONSTANT);
        AnchorPane.setBottomAnchor(view, ANCHOR_CONSTANT);
        AnchorPane.setTopAnchor(view, ANCHOR_CONSTANT);
        shortViewController.setModel(tableModels.getSelectionModel().getSelectedItem());

        bottomPane.getChildren().addAll(shortViewController.getView());


    }

    @Override
    public void refresh() {
        modelData.removeAll(modelData);
        modelData.addAll(modelService.getAll());


    }
}
