package com.av.ui.managers;

import com.av.domain.Model;
import com.av.repositories.ModelService;
import com.av.ui.controllers.Controller;
import com.av.ui.controllers.dilalogs.ModelFormController;
import com.av.ui.utils.SpringFXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import org.springframework.stereotype.Service;

import javax.xml.bind.attachment.AttachmentMarshaller;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
@Service
@Lazy
public class ModelManager extends AbstractDataManager<Model> {

    private static Logger modelManagerLogger = Logger.getLogger(ModelManager.class.getName());
    @Autowired
    private ModelService modelService;

    public void setTableselectionModel(TableSelectionModel tableselectionModel) {
        this.tableSelectionModel = tableselectionModel;
    }

    @Override
    public Model editItem(Model item) {
        modelManagerLogger.log(Level.INFO, "Edit:" + item);

        ModelFormController controller = (ModelFormController) SpringFXMLLoader.load("/fxml/dialogs/ModelForm.fxml");
        AnchorPane view = (AnchorPane) controller.getView();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Model");
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(view);
        dialogStage.setScene(scene);
        controller.setModel(item);
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();

        if (controller.isOkClicked()) {
            modelManagerLogger.info("model save");
            modelService.Save(item);

            modelManagerLogger.info("model saved");
        }


        //


        return item;
    }

    @Override
    public Model addItem() {
        modelManagerLogger.log(Level.INFO, "add item");
        return new Model();
    }

    @Override
    public String getLabel() {
        return "Управление моделями";
    }

    @Override
    public String getViewName() {
        return "/fxml/ModelTableView.fxml";
    }
}
