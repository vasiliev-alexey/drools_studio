package com.av.ui.controllers;

import javafx.scene.Node;

/**
 * Created by alexey on 16.12.16.
 */
public interface Controller {
    Node getView();
    void setView (Node view);
}
