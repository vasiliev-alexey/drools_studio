package com.av.ui.controllers.dialogs;

import com.av.ui.utils.Action;
import javafx.event.ActionEvent;

/**
 * Created by vasiliev-alexey on 11.02.17.
 */
 
public class ActionController {

    private Action action;

    public void setAction(Action action) {
        this.action = action;

    }

    public void handleOk(ActionEvent actionEvent) {
        action.perform();
    }

    public void handleCancel(ActionEvent actionEvent) {
        action.perform();
    }
}
