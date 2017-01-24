package com.av.ui.managers;

import com.av.domain.accounting.AccountCalendar;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by vasiliev-alexey on 22.01.17.
 */
@Service
@Lazy
public class AccountCalendarManager extends AbstractDataManager<AccountCalendar> {
    @Override
    public AccountCalendar addItem() {
        return null;
    }

    @Override
    public String getLabel() {
        return "Учетный календарь";
    }

    @Override
    public String getViewName() {
        return "/fxml/tableviews/AccountCalendarTableView.fxml";
    }


    @Override
    public Node getIcon() {
        return new ImageView(new Image(
                getClass().getResourceAsStream("/icons/schedule_16x16.png")));
    }


}
