package com.av.ui.managers;

import com.av.domain.accounting.Event;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Service;

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
        return new ImageView( new Image(
                getClass().getResourceAsStream("/icons/event_16x16.png")));
    }
}
