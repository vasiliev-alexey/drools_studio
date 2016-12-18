package com.av.ui.treeitems;

import com.av.domain.Model;
import com.av.ui.controlers.TreeModelEvent;
import javafx.event.EventType;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;

/**
 * Created by vasiliev-alexey on 17.12.16.
 */
public class ModelTreeItem extends TreeItem<String> {



    public ModelTreeItem() {
        super();

        setValue("Модели 2");
    }
    @Override
    public boolean isLeaf() {
        return true;
    }



}
