package com.av.ui.controllers;

import javafx.scene.Node;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public class AbstractController implements Controller {

    protected Node view;

    @Override
    public Node getView() {
        return view;
    }

    @Override
    public void setView(Node view) {
        this.view = view;

    }
}
