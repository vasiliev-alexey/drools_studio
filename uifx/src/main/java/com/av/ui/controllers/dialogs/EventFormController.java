package com.av.ui.controllers.dialogs;

import com.av.data.services.ModelService;
import com.av.domain.accounting.Event;
import com.av.domain.settings.Model;
import com.av.ui.controllers.AbstractController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vasiliev-alexey on 24.01.17.
 */
public class EventFormController extends AbstractController {


    private Event event;
    private Stage dialogStage;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField eventCodeTxb;
    @FXML
    private TextField eventNameTxb;
    @FXML
    private TextField modelNameTxb;
    @FXML
    private ComboBox<Model> cmbModelCode;
    @FXML
    private CheckBox enabledFlag;
    @FXML
    private GridPane headerPane;

    private ObservableList<Model> models;

    @Autowired
    private ModelService modelService;

    public void setDependencyValue(Stage dialogStage, Event item, boolean readOnly) {

        this.dialogStage = dialogStage;
        event = item;


        if (readOnly) {
            setReadOnly(headerPane);
        } else {
            models = modelService.getAll();
        }
        bind();
    }


    private void bind() {
        eventCodeTxb.textProperty().bindBidirectional(event.codeProperty());
        eventNameTxb.textProperty().bindBidirectional(event.nameProperty());
        if (event.modelProperty().getValue() != null) {
            modelNameTxb.textProperty().bindBidirectional(event.modelProperty().get().modelNameProperty());

            ObservableList<Model> l = FXCollections.observableArrayList();
            l.addAll(event.getModel());


            cmbModelCode.getSelectionModel().select(event.getModel());
        }
        cmbModelCode.setItems(models);
        cmbModelCode.setConverter(new StringConverter<Model>() {

            @Override
            public String toString(Model object) {
                return object.codeProperty().getValue();
            }

            @Override
            public Model fromString(String string) {

                return models.stream().filter(m -> string.equals(m.codeProperty().getValue())).findFirst().get();

            }
        });

        cmbModelCode.valueProperty().addListener((observable, oldValue, newValue) -> {
            modelNameTxb.textProperty().unbind();
            event.modelProperty().setValue(newValue);
            modelNameTxb.textProperty().bindBidirectional(event.modelProperty().get().modelNameProperty());

        });


        enabledFlag.selectedProperty().bindBidirectional(event.enabledProperty());


    }
}
