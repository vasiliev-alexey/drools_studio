package com.av.ui.managers;

import com.av.domain.Model;
import javafx.scene.control.TableSelectionModel;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
@Service
@Lazy
public class ModelManager extends AbstractDataManager<Model>{


    private static Logger modelManagerLogger = Logger.getLogger(ModelManager.class.getName());

    public void setTableselectionModel(TableSelectionModel tableselectionModel) {
        this.tableSelectionModel = tableselectionModel;
    }



    @Override
    public void EditItem(Model item) {
        modelManagerLogger.log(Level.INFO , "Edit:" + item);
    }

    @Override
    public Model addItem(Model model) {

        modelManagerLogger.log(Level.INFO , "add item");

        return model;
    }

    @Override
    public String getLabel() {
        return  "Управление моделями";
    }
}
