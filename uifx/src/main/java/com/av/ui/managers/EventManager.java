package com.av.ui.managers;

import com.av.domain.accounting.Event;
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
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vasiliev-alexey on 21.12.16.
 */
@Service
public class EventManager extends AbstractDataManager<Event> {

    private static Logger logger = Logger.getLogger(EventManager.class.getName());

    @Override
    public String getLabel() {
        return "События";
    }

    @Override
    public String getViewName() {
        return "/fxml/tableviews/EventTableView.fxml";
    }

    @Override
    public Event addItem() {
        logger.info("add item  Event");

        return null;
    }

    @Override
    public Node getIcon() {
        return new ImageView(new Image(
                getClass().getResourceAsStream("/icons/event_16x16.png")));
    }

    @Override
    public Event editItem(Event item) {
        logger.log(Level.INFO, "Edit:" + item);

        EventFormController controller = (EventFormController) SpringFXMLLoader.load("/fxml/dialogs/EventForm.fxml");


        DialogBuilder dialogBuilder = new DialogBuilder()
                .setPane( (AnchorPane) controller.getView())
                .setTitle("Редактирование учетного события " + item.codeProperty().getValue());
        controller.setDependencyValue( item, false , dialogBuilder.getAction());
        dialogBuilder.showAndWait();
        return  item;
    }

}
