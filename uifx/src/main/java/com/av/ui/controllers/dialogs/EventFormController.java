package com.av.ui.controllers.dialogs;

import com.av.data.services.ChartOfAccountStructureService;
import com.av.data.services.EventService;
import com.av.data.services.ModelService;
import com.av.domain.accounting.ChartOfAccountStructure;
import com.av.domain.accounting.Event;
import com.av.domain.accounting.EventRule;
import com.av.domain.settings.Model;
import com.av.ui.controllers.AbstractController;
import com.av.ui.treeitems.EditCell;
import com.av.ui.utils.Command;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by vasiliev-alexey on 24.01.17.
 */
public class EventFormController extends AbstractController {

    @FXML
    public VBox rulesMainBox;
    @FXML
    public Button btnCondition;
    @FXML
    public TableView eventRulesTable;
    @FXML
    public TableColumn ruleCode;
    @FXML
    public TableColumn ruleName;
    @FXML
    public TableColumn ruleEnabled;
    @FXML
    public TitledPane headerGridPane;
    @FXML
    public ComboBox<ChartOfAccountStructure> cmbChartStructure;
    @FXML
    public HBox rulesBox;
    private Event event;
    private List<EventRule> eventRules;
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

    private ObservableList<ChartOfAccountStructure> chartOfAccountStructures;

    @Autowired
    private ModelService modelService;
    @Autowired
    private ChartOfAccountStructureService chartOfAccountStructureService;
    @Autowired
    private EventService eventService;
    private Command close;

    public void setDependencyValue(Event item, boolean readOnly , Command close) {
        this.close = close;
        event = item;
        eventRules = item.getEventRules();

        if (readOnly) {
            setReadOnly(headerPane);
        } else {
            models = modelService.getAll();
            chartOfAccountStructures = chartOfAccountStructureService.getAll();
        }
        bind();
    }


    private void bind() {
        eventCodeTxb.textProperty().bindBidirectional(event.codeProperty());
        eventNameTxb.textProperty().bindBidirectional(event.nameProperty());
        if (event.modelProperty().getValue() != null) {
            modelNameTxb.textProperty().bind(event.modelProperty().get().modelNameProperty());

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
            //modelNameTxb.textProperty().unbind();
            event.modelProperty().setValue(newValue);
            //modelNameTxb.textProperty().bind(event.modelProperty().get().modelNameProperty());

        });

        cmbChartStructure.setItems(chartOfAccountStructures);
        cmbChartStructure.setConverter(new StringConverter<ChartOfAccountStructure>() {
            @Override
            public String toString(ChartOfAccountStructure object) {
                return object.getName();
            }

            @Override
            public ChartOfAccountStructure fromString(String string) {
                return null;
            }
        });

        cmbChartStructure.valueProperty().addListener((observable, oldValue, newValue) -> {
            event.chartOfAccountStructureProperty().setValue(newValue);
        });

        if (event.chartOfAccountStructureProperty() != null) {
            cmbChartStructure.getSelectionModel().select(event.getChartOfAccountStructure());
        }

        cmbChartStructure.disableProperty().bind(Bindings.isNotEmpty(FXCollections.observableArrayList(eventRules)));
        cmbModelCode.disableProperty().bind(cmbChartStructure.disabledProperty());

        enabledFlag.selectedProperty().bindBidirectional(event.enabledProperty());

        eventRulesTable.getItems().addAll(event.getEventRules());
        ruleEnabled.setCellFactory(CheckBoxTableCell.forTableColumn(ruleEnabled));

        ruleCode.setCellFactory(d -> EditCell.createStringEditCell());
        ruleName.setCellFactory(d -> EditCell.createStringEditCell());

        headerGridPane.expandedProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue) {
                rulesMainBox.setLayoutY(headerPane.getRowConstraints().size() * 37);
            } else {
                rulesMainBox.setLayoutY(30);
            }

        });

        eventRulesTable.prefWidthProperty().bind(rulesBox.prefWidthProperty().add(-50d));
        ruleName.prefWidthProperty().bind(eventRulesTable.prefWidthProperty().multiply(0.66d));
        ruleCode.prefWidthProperty().bind(eventRulesTable.prefWidthProperty().multiply(0.18d));
        ruleEnabled.prefWidthProperty().bind(eventRulesTable.prefWidthProperty().multiply(0.16d));


        btnCondition.disableProperty().bind(Bindings.isEmpty( eventRulesTable.getSelectionModel().getSelectedItems()));

    }

    public void handleOk(ActionEvent actionEvent) {
        eventService.save(event);
        close.perform();

    }

    public void handleCancel(ActionEvent actionEvent) {
        close.perform();
    }
}
