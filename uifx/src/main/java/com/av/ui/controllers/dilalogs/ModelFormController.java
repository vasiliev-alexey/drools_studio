package com.av.ui.controllers.dilalogs;

import com.av.domain.GroupType;
import com.av.domain.Model;
import com.av.domain.ModelAttrGroup;
import com.av.ui.controllers.AbstractController;
import com.av.ui.treeitems.EditCell;
import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

/**
 * Created by vasiliev-alexey on 23.12.16.
 */
public class ModelFormController extends AbstractController {

    private Model model;
    private boolean okClicked = false;
    private ObservableList<ModelAttrGroup> groups = FXCollections.observableArrayList();
    private Stage dialogStage;
    @FXML
    private TextField txtCode;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPackage;
    @FXML
    private TableView<ModelAttrGroup> tableGroup;
    @FXML
    private TableColumn<ModelAttrGroup, String> codeColumn;
    @FXML
    private TableColumn<ModelAttrGroup, String> nameColumn;
    @FXML
    private TableColumn<ModelAttrGroup, GroupType> typeColumn;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

    }

    private  void initTtable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(column -> EditCell.createStringEditCell());

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        codeColumn.setCellFactory(column -> EditCell.createStringEditCell());


        codeColumn.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setCode(event.getNewValue()));


        typeColumn.setCellValueFactory(cellData -> cellData.getValue().groupTypeProperty());
        typeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(GroupType.values()));

        txtCode.textProperty().bindBidirectional(this.model.codeProperty());
        txtName.textProperty().bindBidirectional(this.model.modelNameProperty());
        txtPackage.textProperty().bindBidirectional(this.model.packageNameProperty());
    }


    public boolean isOkClicked() {

        return okClicked;
    }

    private <T> TableColumn<T, String> createColumn(String title, Function<T, StringProperty> property) {
        TableColumn<T, String> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));

        col.setCellFactory(column -> EditCell.createStringEditCell());
        return col;
    }

        public void setModel(Model model) {
        groups.clear();
        this.model = model;
        groups = FXCollections.observableArrayList(model.getModelAttrGroups());
        tableGroup.setItems(groups);
        tableGroup.setFixedCellSize(25);
        tableGroup.prefHeightProperty().bind(Bindings.size(tableGroup.getItems()).multiply(tableGroup.getFixedCellSize()).add(30));
        initTtable();

    }

    public void handleOk(ActionEvent actionEvent) {

        okClicked = true;

        dialogStage.close();
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}