package com.av.ui.managers;

import javafx.scene.Node;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public abstract class AbstractDataManager<T> implements StandardAction<T> {


    protected TableSelectionModel<T> tableSelectionModel;


    protected String viewName;


    public abstract String getLabel();

    public abstract String getViewName();

    public Node getIcon() {
      return new ImageView( new Image(
                getClass().getResourceAsStream("/icons/folder.png")));
    };

}
