package com.av.ui.controllers.dialogs;

import com.av.domain.Error;
import com.av.ui.controllers.AbstractController;
import com.av.ui.controllers.Controller;
import com.av.ui.treeitems.EditCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by vasiliev-alexey on 02.01.17.
 */
public class ErrorsDialogController implements Controller {

    private Node view;
    private Stage dialogStage;

    @FXML
    private TableView<Error> errorTable;
    @FXML
    private TableColumn<Error , String> errType;
    @FXML
    private TableColumn<Error , String> errMessage;


    private ObservableList<Error> errorSet;



    public void handleOk(ActionEvent actionEvent) {

        dialogStage.close();

    }

    public void setErrorSet(ObservableList<Error> errorSet , Stage stage ) {
        this.errorSet =   errorSet;
        errorTable.setItems(errorSet);
        errType.setCellValueFactory( celdata -> celdata.getValue().errTypeProperty());
        errType.setCellFactory(column -> EditCell.createStringEditCell());

        errMessage.setCellValueFactory(celdata -> celdata.getValue().errMessageProperty());
        errMessage.setCellFactory(column -> EditCell.createStringEditCell());
        dialogStage = stage;



    }

    @Override
    public Node getView() {

        return view;
    }

    @Override
    public void setView(Node view) {
        this.view = view;

    }
}
