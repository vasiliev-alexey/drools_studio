package com.av.ui.controllers.dialogs;

import com.av.domain.*;
import com.av.ui.controllers.AbstractController;
import com.av.ui.treeitems.EditCell;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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

    @FXML
    private Button addGroupBtn;

    @FXML
    private Button delGroupBtn;


    @FXML
    private Button addAttrBtn;

    @FXML
    private Button delAttrBtn;


    /**
     * метод для высталния начальных свойств для таблиц формы редактрования
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

        codeColumn.prefWidthProperty().bind(tableGroup.prefWidthProperty().multiply(0.25));
        nameColumn.prefWidthProperty().bind(tableGroup.prefWidthProperty().multiply(0.5));
        typeColumn.prefWidthProperty().bind(tableGroup.prefWidthProperty().multiply(0.25));

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

        tableGroup.prefWidthProperty().bind(mainPane.widthProperty().subtract(60d));
        attrTable.prefWidthProperty().bind(tableGroup.prefWidthProperty());

        attrCode.prefWidthProperty().bind(attrTable.prefWidthProperty().multiply(0.25));
        attrName.prefWidthProperty().bind(attrTable.prefWidthProperty().multiply(0.5));
        attrType.prefWidthProperty().bind(attrTable.prefWidthProperty().multiply(0.25));


        tableGroup.getSelectionModel().selectFirst();
        delGroupBtn.disableProperty().bind(Bindings.isEmpty( tableGroup.getSelectionModel().getSelectedItems()));
        delAttrBtn.disableProperty().bind(  delGroupBtn.disableProperty());
        addAttrBtn.disableProperty().bind(delGroupBtn.disabledProperty());

    }


    /**
     *
     * @return возвращет свойство что была нажата кнопка OK
     */
    public boolean isOkClicked() {

        return okClicked;
    }

    /**
     *
     * @param dialogStage - диалоговое окно - родитель
     * @param model  - модель для редактирования
     * @param readOnly - флаг только для чтения
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

    /**
     *
     * @param actionEvent -
     */
    @FXML
    public void handleOk(ActionEvent actionEvent) {

        okClicked = true;

        dialogStage.close();
    }

    @FXML
    /**
     * событие по нажатию на кнопку Отмена
     */
    private void handleCancel() {
        dialogStage.close();
    }


    /**
     *
     * @param actionEvent - Событие по нажатию на кнопку табличных редакторов
     */

    @FXML
    private void tableMouseClick(ActionEvent actionEvent) {
        if( actionEvent.getSource() == addAttrBtn) {

            ModelAttr modelAttr = new ModelAttr();
            modelAttr.setModelAttrGroup(tableGroup.getSelectionModel().getSelectedItem());
            tableGroup.getSelectionModel().getSelectedItem().getModelAttrList().add(modelAttr);
            attrTable.getItems().addAll(modelAttr);
            attrTable.getSelectionModel().selectLast();


        }
        else if (actionEvent.getSource() == delAttrBtn) {
            Object modelAttr =    attrTable.getSelectionModel().getSelectedItem();
            tableGroup.getSelectionModel().getSelectedItem().getModelAttrList().remove(modelAttr);
            attrTable.getItems().removeAll(modelAttr);
        }

        else if (actionEvent.getSource() == delGroupBtn) {
            model.getModelAttrGroups().remove(tableGroup.getSelectionModel().getSelectedItem());
            groups.removeAll(tableGroup.getSelectionModel().getSelectedItem());
            attrTable.getItems().clear();

        }

        else  if(actionEvent.getSource() == addGroupBtn) {

            ModelAttrGroup mag = new ModelAttrGroup();
            mag.setModel(model);
            model.getModelAttrGroups().add (mag);
            groups.addAll(mag);

            tableGroup.getSelectionModel().selectLast();

        }

    }



}
