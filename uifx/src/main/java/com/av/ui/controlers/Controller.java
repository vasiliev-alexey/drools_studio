package com.av.ui.controlers;

import javafx.scene.Node;

/**
 * Created by alexey on 16.12.16.
 */
public interface Controller {
    Node getView();
    void setView (Node view);
}
