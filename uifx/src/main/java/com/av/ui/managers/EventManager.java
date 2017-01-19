package com.av.ui.managers;

import com.av.domain.accounting.Event;
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
        return "/fxml/EventTableView.fxml";
    }

    @Override
    public Event addItem() {
        logger.info("add item  Event");

        return null;
    }

    @Override
    public Event editItem(Event event) {
        logger.info("edit item  Event");
        return new Event();
    }

    @Override
    public void removeItem(Event event) {

    }
}
