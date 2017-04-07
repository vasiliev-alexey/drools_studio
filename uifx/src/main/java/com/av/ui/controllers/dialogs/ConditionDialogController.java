package com.av.ui.controllers.dialogs;

import com.av.domain.accounting.EventRule;
import com.av.domain.settings.Condition;
import com.av.domain.settings.ConditionLine;
import com.av.domain.settings.LogicOperatorType;
import com.av.domain.settings.StandardValueType;
import com.av.ui.controllers.AbstractController;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by vasiliev-alexey on 11.02.17.
 */
public class ConditionDialogController extends AbstractController {
    private final Logger LOG = Logger.getLogger(ConditionDialogController.class);
    @FXML
    public TableColumn<ConditionLine , Number> priorColumn;
    @FXML
    public TableColumn<ConditionLine , String> leftBracketColumn;
    @FXML
    public TableColumn<ConditionLine  , LogicOperatorType> logicOperator;
    @FXML
    public TableColumn <ConditionLine , String>rightBracketColumn;
    @FXML
    public TableColumn leftValueOperator;
    @FXML
    public TableColumn leftTypeOperator;
    @FXML
    public TableColumn operandColumn;
    @FXML
    public TableColumn leftOperatorValue;
    @FXML
    public TableColumn leftTypeOperatorColumn;
    @FXML
    public TableView lineTable;
    @Autowired
    private ActionController actionController;

    private EventRule eventRule;
    private Stage stage;
    private Condition condition;
    private ObservableList<ConditionLine> conditionLines;


    public void setEventRule(Stage stage, EventRule eventRule) {
        this.eventRule = eventRule;
        this.stage = stage;
        this.condition = eventRule.getCondition();


        bind();

    }


    private void bind() {



        if(condition == null) {
            condition= new Condition();
            condition.setCode(UUID.randomUUID().toString());
            condition.setConditionLines(new ArrayList<ConditionLine>());

        }
        conditionLines = FXCollections.observableArrayList(condition.getConditionLines());
        lineTable.setItems(conditionLines);

        leftBracketColumn.setCellValueFactory(cellData -> cellData.getValue().leftBracketProperty());
        leftBracketColumn.setCellFactory(ComboBoxTableCell.forTableColumn("" , "("));
        rightBracketColumn.setCellValueFactory(cellData -> cellData.getValue().rightBracketProperty());
        rightBracketColumn.setCellFactory(ComboBoxTableCell.forTableColumn("" , ")"));
        logicOperator.setCellValueFactory(cellData -> cellData.getValue().logicOperatorTypeProperty());
        logicOperator.setCellFactory(ComboBoxTableCell.forTableColumn(LogicOperatorType.values()));


        priorColumn.setCellValueFactory(cellData -> cellData.getValue().userSeqProperty());

        priorColumn.setCellFactory(TextFieldTableCell.<ConditionLine, Number>
                forTableColumn(new NumberStringConverter()));

    }


    public void handleOk(ActionEvent actionEvent) {
        stage.close();
    }

    public void handleCancel(ActionEvent actionEvent) {
        stage.close();
    }

    public void delLineCondition(ActionEvent actionEvent) {

        LOG.info("del");

    }

    public void addLineCondition(ActionEvent actionEvent) {


        ConditionLine line = new ConditionLine();
        line.setCondition(condition);


        conditionLines.add(line);

        //condition.getConditionLines().add(line);


        lineTable.requestFocus();
        lineTable.getSelectionModel().select(line);
        //lineTable.getFocusModel().focus(0);

       // lineTable.getS

    }
}
