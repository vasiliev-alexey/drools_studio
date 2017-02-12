package com.av.ui.managers;

import com.av.data.services.ModelService;
import com.av.domain.settings.Error;
import com.av.domain.settings.Model;
import com.av.domain.settings.ModelAttrGroup;
import com.av.ui.controllers.ModelTableViewController;
import com.av.ui.controllers.dialogs.ModelFormController;
import com.av.ui.utils.DialogBuilder;
import com.av.ui.utils.SpringFXMLLoader;
import com.av.validators.ModelBeanValidationServiceImpl;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
@Service
@Lazy
public class ModelManager extends AbstractDataManager<Model> {

    private final Logger modelManagerLogger = Logger.getLogger(ModelManager.class.getName());
    @Autowired
    private ModelService modelService;

    @Autowired
    private ModelBeanValidationServiceImpl validationService;

    @Autowired
    private ModelTableViewController modelTableViewController;

    @Override
    public Model editItem(Model item) {
        modelManagerLogger.log(Level.INFO, "Edit:" + item);

        ModelFormController controller = (ModelFormController) SpringFXMLLoader.load("/fxml/dialogs/ModelForm.fxml");
        AnchorPane view = (AnchorPane) controller.getView();

        DialogBuilder dialogStage = new DialogBuilder()
                .setPane(view)
                .setModelity(Modality.APPLICATION_MODAL)
                .setTitle("Редактирование модели")

                 ;
        controller.setDependencyValue(item, false ,  dialogStage.getCommand());

        dialogStage.showAndWait();

        if (controller.isOkClicked()) {
            modelManagerLogger.info("model save");
            ObservableList<Error> constraintViolations = validationService.validateModel(item);
            if (constraintViolations.isEmpty()) {
                modelService.save(item);
                modelManagerLogger.info("model saved - completed");
            } else {
                modelManagerLogger.info("model has error - save rejected");

                showErrorsDialog(constraintViolations);
            }
        } else {


        }
        return item;
    }

    @Override
    public void removeItem(Model model) {

        modelService.remove(model);
        modelTableViewController.refresh();

    }

    @Override
    public Model addItem() {
        modelManagerLogger.log(Level.INFO, "add item");

        Model newModel = new Model();
        List<ModelAttrGroup> mag = new ArrayList<>();
        newModel.setModelAttrGroups(mag);


        newModel = editItem(newModel);

        modelTableViewController.refresh();

        return newModel;
    }

    @Override
    public String getLabel() {
        return "Управление моделями";
    }

    @Override
    public String getViewName() {
        return "/fxml/tableviews/ModelTableView.fxml";
    }


    @Override
    public Node getIcon() {
        return new ImageView(new Image(
                getClass().getResourceAsStream("/icons/model.png")));
    }
}
