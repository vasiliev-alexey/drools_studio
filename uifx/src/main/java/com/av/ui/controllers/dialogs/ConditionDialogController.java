package com.av.ui.controllers.dialogs;

import com.av.domain.accounting.EventRule;
import com.av.ui.controllers.AbstractController;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vasiliev-alexey on 11.02.17.
 */
public class ConditionDialogController extends AbstractController{

    @Autowired
    private ActionController actionController;

    private EventRule eventRule;
    private Stage stage;

    public void setEventRule(Stage stage , EventRule eventRule) {
        this.eventRule = eventRule;
        this.stage = stage;
    }

    public void handleOk(ActionEvent actionEvent) {
        stage.close();
    }

    public void handleCancel(ActionEvent actionEvent) {
        stage.close();
    }
}
