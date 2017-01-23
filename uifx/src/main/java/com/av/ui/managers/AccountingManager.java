package com.av.ui.managers;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by vasiliev-alexey on 22.01.17.
 */
public class AccountingManager extends AbstractDataManager {
    @Override
    public Object addItem() {
        return null;
    }

    @Override
    public String getLabel() {
        return "Настройки учета";
    }

    @Override
    public String getViewName() {
        return null;
    }


    @Override
    public Node getIcon() {
        return new ImageView( new Image(
                getClass().getResourceAsStream("/icons/account_setting_2_16x16.png")));
    }
}
