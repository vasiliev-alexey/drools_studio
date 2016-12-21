package com.av.ui.managers;

import com.av.domain.Event;
import org.springframework.stereotype.Service;

/**
 * Created by vasiliev-alexey on 21.12.16.
 */
@Service
public class EventManager extends AbstractDataManager <Event> {

    @Override
    public String getLabel() {
        return "События";
    }

    @Override
    public String getViewName() {
       return  "/fxml/EventTableView.fxml";
    }

    @Override
    public Event addItem() {
        System.out.println("adddddddddddddddd");

        return null;
    }

    @Override
    public Event editItem(Event event) {
        System.out.println("eeeeeeeeeeeeeeeeddddddddddddddd");
        return  new Event();
    }
}
