package com.av.ui.treeitems;

import javafx.scene.control.TreeItem;

/**
 * Created by vasiliev-alexey on 17.12.16.
 */
public class ModelTreeItem extends TreeItem<String> {


    public ModelTreeItem() {
        super();
        setValue("Модели");
    }

    @Override
    public boolean isLeaf() {
        return true;
    }


}
