package com.av.ui.controllers.dialogs;

import com.av.domain.accounting.EventRule;
import com.av.domain.settings.Condition;
import com.av.domain.settings.ConditionLine;
import com.av.domain.settings.enums.ConditionType;
import com.av.domain.settings.enums.LogicOperatorType;
import com.av.domain.settings.enums.OperandType;
import com.av.ui.controllers.AbstractController;
import com.av.ui.treeitems.EditCell;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
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
    public TableColumn<ConditionLine, Number> priorColumn;
    @FXML
    public TableColumn<ConditionLine, String> leftBracketColumn;
    @FXML
    public TableColumn<ConditionLine, LogicOperatorType> logicOperator;
    @FXML
    public TableColumn<ConditionLine, String> rightBracketColumn;
    @FXML
    public TableColumn rightOperatorValue;
    @FXML
    public TableColumn<ConditionLine, ConditionType> rightTypeOperator;
    @FXML
    public TableColumn<ConditionLine, OperandType> operandColumn;
    @FXML
    public TableColumn leftOperatorValue;
    @FXML
    public TableColumn<ConditionLine, ConditionType> leftTypeOperator;
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


        if (condition == null) {
            condition = new Condition();
            condition.setCode(UUID.randomUUID().toString());
            condition.setConditionLines(new ArrayList<ConditionLine>());

        }
        conditionLines = FXCollections.observableArrayList(condition.getConditionLines());
        lineTable.setItems(conditionLines);

        leftBracketColumn.setCellValueFactory(cellData -> cellData.getValue().leftBracketProperty());
        leftBracketColumn.setCellFactory(ComboBoxTableCell.forTableColumn("", "("));
        rightBracketColumn.setCellValueFactory(cellData -> cellData.getValue().rightBracketProperty());
        rightBracketColumn.setCellFactory(ComboBoxTableCell.forTableColumn("", ")"));
        logicOperator.setCellValueFactory(cellData -> cellData.getValue().logicOperatorTypeProperty());
        logicOperator.setCellFactory(ComboBoxTableCell.forTableColumn(LogicOperatorType.values()));

        operandColumn.setCellValueFactory(cellData -> cellData.getValue().operandTypeProperty());
        operandColumn.setCellFactory(ComboBoxTableCell.forTableColumn(OperandType.values()));


        // leftTypeOperator.setCellValueFactory(cellData -> cellData.getValue().());
        rightTypeOperator.setCellFactory(ComboBoxTableCell.forTableColumn(ConditionType.DOCUMENT_ATTRIBUTE,
                ConditionType.CONSTANT));
/*
        ArrayList<ConditionType> conditionTypes = new ArrayList<>(Arrays.asList(ConditionType.values()));
     ObservableList<ConditionType> leftvalues = FXCollections.observableList(conditionTypes.stream()
                .filter( v -> v!=ConditionType.CONSTANT).collect(Collectors.toList()));
*/
        leftTypeOperator.setCellFactory(cel -> {
            return new TableCell<ConditionLine, ConditionType>() {
                @Override
                protected void updateItem(ConditionType item, boolean empty) {
                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                       if(!empty) {
                           ComboBox<ConditionType> leftOperator = new ComboBox<ConditionType>();
                           leftOperator.getItems().setAll(ConditionType.CONSTANT);
                           setGraphic(leftOperator);



                       }

                    } else {
                        ComboBox<ConditionType> leftOperator = new ComboBox<ConditionType>();
                        leftOperator.getItems().setAll(ConditionType.CONSTANT);
                        setGraphic(leftOperator);

                     ConditionLine c =
                             (ConditionLine)lineTable.getSelectionModel().getSelectedItem();



                    }

                    }

            };



            });


            /*  TableCell<ConditionLine, ConditionType> cell = new TableCell<>();

            ComboBox<ConditionType> leftOperator = new ComboBox<ConditionType>();
            leftOperator.getItems().setAll(ConditionType.CONSTANT);

            cell.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);


            cell.setGraphic(leftOperator);



            return cell;


        });
*/





        priorColumn.setCellValueFactory(cellData -> cellData.getValue().userSeqProperty());
        priorColumn.setCellFactory(column -> EditCell.createNumberEditCell());

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
        line.setUserSeq(null);

        conditionLines.add(line);

        //condition.getConditionLines().add(line);


        lineTable.requestFocus();
        lineTable.getSelectionModel().select(line);
        //lineTable.getFocusModel().focus(0);

        // lineTable.getS

    }



}
