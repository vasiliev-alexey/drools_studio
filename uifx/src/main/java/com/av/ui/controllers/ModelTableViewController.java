package com.av.ui.controllers;

import com.av.domain.Model;
import com.av.repositories.ModelService;
import com.av.ui.utils.SpringFXMLLoader;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.View;
import java.net.URL;
import java.util.DoubleSummaryStatistics;
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
    private TableColumn<Model , String>  codeColumn;
    @FXML
    private TableColumn<Model , String>  nameColumn;

    @Autowired
    private ModelService modelService;


    @Autowired
    private AnchorPane bottomPane;


    private ModelShortViewController shortViewController;


    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        codeColumn.setCellValueFactory(new PropertyValueFactory<Model, String>("code"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Model, String>("modelName"));



        modelData = modelService.getAll();
        tableModels.setItems(modelData);
        tableModels.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        tableModels.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            mouseEnterd(null);
        });


    }


    public void mouseEnterd(MouseEvent mouseEvent) {
        bottomPane.getChildren().clear();
        shortViewController = (ModelShortViewController) SpringFXMLLoader.load("/fxml/ModelShortView.fxml");
        Node view = shortViewController.getView();


        AnchorPane.setLeftAnchor(view , ANCHOR_CONSTANT );
        AnchorPane.setRightAnchor(view , ANCHOR_CONSTANT );
        AnchorPane.setBottomAnchor(view , ANCHOR_CONSTANT );
        AnchorPane.setTopAnchor(view , ANCHOR_CONSTANT );
        shortViewController.setModel(tableModels.getSelectionModel().getSelectedItem());

        bottomPane.getChildren().addAll(shortViewController.getView());






    }
}
