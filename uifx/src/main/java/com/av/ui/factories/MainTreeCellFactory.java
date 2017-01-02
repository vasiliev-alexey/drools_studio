package com.av.ui.factories;

import com.av.ui.managers.AbstractDataManager;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

/**
 * Created by vasiliev-alexey on 17.12.16.
 */
public class MainTreeCellFactory implements Callback<TreeView, TreeCell> {
    @Override
    public TreeCell call(TreeView param) {

        TreeCell treeCell = new TreeCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setText(null);
                } else if (item != null) {
                    if (item instanceof AbstractDataManager) {

                        setText(((AbstractDataManager) item).getLabel());
                        setGraphic(((AbstractDataManager) item).getIcon());
                    } else setText(item.toString());
                }
            }
        };
        return treeCell;
    }
}
