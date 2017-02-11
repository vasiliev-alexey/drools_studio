package com.av.ui.controllers.dialogs;

import com.av.ui.utils.Command;
import javafx.event.ActionEvent;

/**
 * Created by vasiliev-alexey on 11.02.17.
 */

public class ActionController {

    private Command commandOk;
    private Command commandClose;

    public void setOnOk(Command command) {
        this.commandOk = command;
    }

    public void setOnClose(Command command) {
        commandClose = command;
    }


    public void handleOk(ActionEvent actionEvent) {
        if (commandOk != null) {
            commandOk.perform();
        } else {
            throw new IllegalStateException("Function on OK not setted");
        }

    }

    public void handleCancel(ActionEvent actionEvent) {
        if (commandClose != null) {
            commandClose.perform();
        } else {
            throw new IllegalStateException("Function on OK not setted");
        }
    }
}
