package com.av.ui.managers;

import com.av.domain.accounting.ChartOfAccountStructure;
import com.av.ui.controllers.dialogs.CASFormController;
import com.av.ui.controllers.dialogs.EventFormController;
import com.av.ui.utils.DialogBuilder;
import com.av.ui.utils.SpringFXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 25.01.17.
 */
@Service
@Lazy
public class CASManager extends AbstractDataManager<ChartOfAccountStructure> {
    private static Logger logger = Logger.getLogger(CASManager.class.getName());

    @Override
    public ChartOfAccountStructure addItem() {
        return null;
    }

    @Override
    public String getLabel() {
        return "Структура плана счетов";
    }

    @Override
    public String getViewName() {
        return "/fxml/tableviews/CASTableView.fxml";
    }

    @Override
    public Node getIcon() {
        return new ImageView(new Image(
                getClass().getResourceAsStream("/icons/structure_16x16.png")));
    }

    @Override
    public ChartOfAccountStructure editItem(ChartOfAccountStructure item) {
        logger.log(Level.INFO, "Edit:" + item);

        CASFormController controller = (CASFormController) SpringFXMLLoader.load
                ("/fxml/dialogs/ChartOfAccountStructureForm.fxml");
        AnchorPane view = (AnchorPane) controller.getView();

        DialogBuilder dialogBuilder = new DialogBuilder()
                .setTitle("Редактирование структуры плана счетов события " + item.codeProperty().getValue())
                .setPane(view)
                ;


     //   Stage dialogStage = new Stage();
     //   view.prefWidthProperty().bind(dialogStage.widthProperty());
        //dialogStage.setWidth(800d);

      //  dialogStage.setTitle();
      //  dialogStage.initModality(Modality.APPLICATION_MODAL);



       // Scene scene = new Scene(view);
        //dialogStage.setScene(scene);
        controller.setDependencyValue(item, false , dialogBuilder.getAction());

        dialogBuilder.showAndWait();
        return  item;
    }
}
