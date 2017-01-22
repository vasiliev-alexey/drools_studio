package com.av.ui.managers;

import com.av.domain.settings.Error;
import com.av.ui.controllers.dialogs.ErrorsDialogController;
import com.av.ui.utils.SpringFXMLLoader;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public abstract class AbstractDataManager<T> implements StandardAction<T> {


    protected TableSelectionModel<T> tableSelectionModel;


    private static Logger logger = Logger.getLogger(AbstractDataManager.class.getName());


    public abstract String getLabel();

    public abstract String getViewName();

    public Node getIcon() {
      return new ImageView( new Image(
                getClass().getResourceAsStream("/icons/folder.png")));
    };



    public void showErrorsDialog(ObservableList<Error> errorSet) {
        ErrorsDialogController controller = (ErrorsDialogController) SpringFXMLLoader.load("/fxml/dialogs/ErrorsDialog.fxml");
        Pane view = (Pane) controller.getView();

        Stage dialogStage = new Stage();

        dialogStage.setTitle("Редактирование модели");
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(view);
        dialogStage.setScene(scene);
        controller.setErrorSet( errorSet , dialogStage);

        dialogStage.showAndWait();

    }


    public T editItem(T item) {
        logger.info("edit item  not implemented");
        return  item;
    }

    public void removeItem(T event) {
        logger.info("remove item  not implemented");

    }
}
