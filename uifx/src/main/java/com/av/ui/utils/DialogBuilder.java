package com.av.ui.utils;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by vasiliev-alexey on 09.02.17.
 */
public class DialogBuilder {

    private Stage dialog;
    private Action action;

    private static final double DEAFAULT_WIDTH = 800d;

    public DialogBuilder() {
        dialog= new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Без названия");
        dialog.setWidth(DEAFAULT_WIDTH);
    }

    public DialogBuilder setTitle(String title) {
        dialog.titleProperty().setValue(title);
        return this;
    }


    public DialogBuilder setModelity(Modality modality) {
        dialog.initModality(modality);
        return this;
    }

    public DialogBuilder setPane(Pane pane) {

        dialog.setScene(new Scene(pane));
        pane.prefWidthProperty().bind(dialog.widthProperty());
        return this;
    }

    public DialogBuilder setWidth(double width) {
        dialog.setWidth(width);
        return this;
    }


    public void showAndWait() {
        if(dialog.getScene() == null) throw new IllegalStateException("Не установлена сцена");
        dialog.showAndWait();
    }

    public Stage get() {
        return dialog;
    }

    public Action getAction() {
        if(action == null) {
            action = () -> dialog.close();
        }

        return action;
    }

    public DialogBuilder setOnClose(Action action) {
        this.action = action;
        return this;
    }





}
