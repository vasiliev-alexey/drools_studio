package com.av.ui.controllers.dialogs;

import com.av.domain.accounting.EventRule;
import com.av.ui.controllers.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vasiliev-alexey on 11.02.17.
 */
public class ConditionDialogController extends AbstractController {
    private final Logger LOG = Logger.getLogger(ConditionDialogController.class);
    @FXML
    public TableColumn priorColumn;
    @FXML
    public TableColumn leftBracketColumn;
    @FXML
    public TableColumn logicOperator;
    @FXML
    public TableColumn rightBracketColumn;
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

    public void setEventRule(Stage stage, EventRule eventRule) {
        this.eventRule = eventRule;
        this.stage = stage;


        bind();

    }


    private void bind() {




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


        LOG.info("add");
    }
}
