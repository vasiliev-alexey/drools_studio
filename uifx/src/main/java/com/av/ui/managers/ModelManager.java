package com.av.ui.managers;

import com.av.domain.Model;
import com.av.repositories.ModelService;
import javafx.scene.control.TableSelectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
    @Autowired
    private ModelService modelService;

    public void setTableselectionModel(TableSelectionModel tableselectionModel) {
        this.tableSelectionModel = tableselectionModel;
    }
    @Override
    public Model editItem(Model item) {

        modelService.Save(item);
        modelManagerLogger.log(Level.INFO , "Edit:" + item);
        return item;
    }

    @Override
    public Model addItem( ) {
        modelManagerLogger.log(Level.INFO , "add item");
        return new Model();
    }

    @Override
    public String getLabel() {
        return  "Управление моделями";
    }
    @Override
    public String getViewName() {
        return "/fxml/ModelTableView.fxml";
    }
}
