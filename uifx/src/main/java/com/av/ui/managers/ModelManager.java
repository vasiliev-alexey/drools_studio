package com.av.ui.managers;

import com.av.domain.Error;
import com.av.domain.Model;
import com.av.repositories.ModelService;
import com.av.ui.controllers.dialogs.ModelFormController;
import com.av.ui.utils.SpringFXMLLoader;
import com.av.validators.ModelBeanValidationServiceImpl;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
public class ModelManager extends AbstractDataManager<Model> {

    private static Logger modelManagerLogger = Logger.getLogger(ModelManager.class.getName());
    @Autowired
    private ModelService modelService;

    @Autowired
    private ModelBeanValidationServiceImpl validationService;

    public void setTableselectionModel(TableSelectionModel tableselectionModel) {
        this.tableSelectionModel = tableselectionModel;
    }

    @Override
    public Model editItem(Model item) {
        modelManagerLogger.log(Level.INFO, "Edit:" + item);

        ModelFormController controller = (ModelFormController) SpringFXMLLoader.load("/fxml/dialogs/ModelForm.fxml");
        AnchorPane view = (AnchorPane) controller.getView();

        Stage dialogStage = new Stage();

        dialogStage.setTitle("Редактирование модели");
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(view);
        dialogStage.setScene(scene);
        controller.setDependencyValue(dialogStage, item, false);

        dialogStage.showAndWait();

        if (controller.isOkClicked()) {
            modelManagerLogger.info("model save");
            ObservableList<Error> constraintViolations = validationService.validateModel(item);
            if (constraintViolations.isEmpty()) {
                modelService.Save(item);
                modelManagerLogger.info("model saved - completed");
            } else {
                System.out.println("model has error - save rejected");

                showErrorsDialog(constraintViolations);
            }
        } else {
            item = modelService.refresh(item);

        }
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


    @Override
    public Node getIcon() {
        return new ImageView(new Image(
                getClass().getResourceAsStream("/icons/model.png")));
    }
}
