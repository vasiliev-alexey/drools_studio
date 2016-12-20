package com.av.ui.managers;

import com.av.domain.Model;
import javafx.scene.control.TableSelectionModel;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
@Service
@Lazy
public class ModelManager extends AbstractDataManager<Model>{


    public void setTableselectionModel(TableSelectionModel tableselectionModel) {
        this.tableSelectionModel = tableselectionModel;
    }

    @Override
    public Model addItem() {
        return null;
    }

    @Override
    public void EditItem(Model item) {
        System.out.println( "Edit:" + item);
    }
}
