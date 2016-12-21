package com.av.ui.controllers;

import com.av.domain.Model;
import com.av.domain.ModelAttrGroup;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringJoiner;

/**
 * Created by vasiliev-alexey on 21.12.16.
 */
@org.springframework.stereotype.Controller
@Lazy
public class ModelShortViewController extends AbstractController implements Initializable{



    private Model model;

    private ObservableList
            <ModelAttrGroup> groups = FXCollections.observableArrayList();

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPackage;

    @FXML
    private TableView<ModelAttrGroup> tableGroup;
    @FXML
    private TableColumn<ModelAttrGroup , String> codeColumn;
    @FXML
    private TableColumn<ModelAttrGroup , String> nameColumn;

    @FXML
    private  TableColumn<ModelAttrGroup, String> typeColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {




      //  txtPackage.textProperty().bind(model.);


    }

    public void setModel(Model model) {
        groups.clear();
        this.model = model;
        groups = FXCollections.observableArrayList(model.getModelAttrGroups());
        nameColumn.setCellValueFactory(new PropertyValueFactory<ModelAttrGroup, String>("name"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<ModelAttrGroup, String>("code"));

        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGroupType().toString()));
        txtCode.textProperty().bind(this.model.codeProperty());
        txtName.textProperty().bind(this.model.modelNameProperty());
        txtPackage.textProperty().bind(this.model.packageNameProperty());

        tableGroup.setItems(groups);
        tableGroup.setFixedCellSize(25);
        tableGroup.prefHeightProperty().bind(Bindings.size(tableGroup.getItems()).multiply(tableGroup.getFixedCellSize()).add(30));

       // codeColumn.textProperty().bind(groups.);

    }
}
