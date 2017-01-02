package com.av.ui.controllers.dialogs;

import com.av.domain.*;
import com.av.ui.controllers.AbstractController;
import com.av.ui.treeitems.EditCell;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by vasiliev-alexey on 23.12.16.
 */
public class ModelFormController extends AbstractController {


    private Model model;
    private boolean okClicked = false;
    private ObservableList<ModelAttrGroup> groups = FXCollections.observableArrayList();
    private Stage dialogStage;


    @FXML
    private AnchorPane mainPane;

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

    @FXML
    private TableView attrTable;
    @FXML
    private TableColumn<ModelAttr, String> attrCode;
    @FXML
    private TableColumn<ModelAttr, String> attrName;
    @FXML
    private TableColumn<ModelAttr, StandardValueType> attrType;


    /*
        @FXML
        public void initialize(URL location, ResourceBundle resources) {

        }
    */
    private void initTable() {
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


        tableGroup.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {

            if (newVal != null) {

                attrTable.setItems(FXCollections.observableArrayList(newVal.getModelAttrList()));
            }

        });

        attrCode.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
        attrCode.setCellFactory(column -> EditCell.createStringEditCell());
        attrName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        attrName.setCellFactory(column -> EditCell.createStringEditCell());

        attrType.setCellValueFactory(cellData -> cellData.getValue().attrValueTypeProperty());
        attrType.setCellFactory(ComboBoxTableCell.forTableColumn(StandardValueType.values()));

        attrTable.prefWidthProperty().bind(mainPane.prefWidthProperty());
        attrCode.prefWidthProperty().bind(attrTable.prefWidthProperty().multiply(0.25));
        attrName.prefWidthProperty().bind(attrTable.prefWidthProperty().multiply(0.5));
        attrType.prefWidthProperty().bind(attrTable.prefWidthProperty().multiply(0.25));

        tableGroup.getSelectionModel().selectFirst();
    }


    public boolean isOkClicked() {

        return okClicked;
    }

    /*/
        private <T> TableColumn<T, String> createColumn(String title, Function<T, StringProperty> property) {
            TableColumn<T, String> col = new TableColumn<>(title);
            col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));

            col.setCellFactory(column -> EditCell.createStringEditCell());
            return col;
        }
    */
    public void setDependencyValue(Stage dialogStage, Model model, boolean readOnly) {
        this.dialogStage = dialogStage;
        this.model = model;
        groups = FXCollections.observableArrayList(model.getModelAttrGroups());
        tableGroup.setItems(groups);
        tableGroup.setFixedCellSize(25);
        tableGroup.prefHeightProperty().bind(Bindings.size(tableGroup.getItems()).multiply(tableGroup.getFixedCellSize()).add(30));
        initTable();


        if (readOnly) {
            setReadOnly(mainPane);
        }

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
