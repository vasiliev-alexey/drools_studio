package com.av.ui.controlers;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Created by Vasiliev.Alexey on 03.12.16.
 */
public class Sample {
    public void on_Mouse_Click(MouseEvent mouseEvent) {


        Button nb = (Button) mouseEvent.getSource();
        System.out.println("Mouse click " + nb.getText());

    }
}
